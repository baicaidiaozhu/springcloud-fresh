package com.yc.fresh.controller;

import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.fresh.entity.MenberInfo;
import com.yc.fresh.service.IMenberInfoBiz;
import com.yc.fresh.util.ResponseUtil;
import com.yc.fresh.util.SendMailUtil;


@Controller
@RequestMapping("/member")
public class MenberInfoController{
	@Autowired
	private IMenberInfoBiz menberInfoBiz ;
	
	@Autowired
	private SendMailUtil sendMailUtil ;

	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(HttpSession session, MenberInfo me) {
		String code = me.getRealName();
		String vcode =(String) session.getAttribute("validateCode");
		if(!code.equalsIgnoreCase(vcode)) {
			return ResponseUtil.responseMap(501, null, null);
		}
		MenberInfo menber = menberInfoBiz.login(me);
		
		if(menber == null){ 
			return ResponseUtil.responseMap(500, null, null);
		}
		session.setAttribute("currentLoginMenber", menber);
		session.setAttribute("mno", menber.getMno());
		return ResponseUtil.responseMap(200, null, null);
	}
	
	
	@RequestMapping("/code")
	@ResponseBody
	public  Map<String,Object>  sendCode(String email, String nickName, HttpSession session ){
		String code="";
		Random rd = new Random();
		while(code.length() <6){
			code+=rd.nextInt(10);
		}
		
		if(sendMailUtil.sendHtmlMail(email, nickName, code)){
			session.setAttribute("vcode", code);
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					session.removeAttribute("vcode");//清空验证码
				}
			};
			
			Timer timer = new Timer();
			timer.schedule(task, 180000); //三分钟之后执行task任务一次
			return ResponseUtil.responseMap(200, null, null);
		}
		return ResponseUtil.responseMap(500, null, null);
	}
	
	@RequestMapping("/reg")
	@ResponseBody
	public Map<String,Object> reg(@RequestParam Map<String, String> map, HttpSession session){
		//获取发送的验证码
		Object obj = session.getAttribute("vcode");
		
		if(obj == null){ //说明验证码过期
			return ResponseUtil.responseMap(501, null, null);
		}
		
		if(!String.valueOf(obj).equals(map.get("yzm"))){ //说明输入的验证码错误
			return ResponseUtil.responseMap(502, null, null);
		}
		int result =menberInfoBiz.reg(map);
		if(result>0) {
			return ResponseUtil.responseMap(200, null, null);
		}
		return ResponseUtil.responseMap(503, null, null);
	}
	
	
	@RequestMapping("/check")
	@ResponseBody
	public Map<String,Object> checkInfo(HttpSession session) {
		Object obj =session.getAttribute("currentLoginMenber");
		if(obj == null) {
			return ResponseUtil.responseMap(500, null, null);
		}
		return  ResponseUtil.responseMap(200, null, obj);
	}
	
}
