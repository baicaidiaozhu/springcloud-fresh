package com.yc.fresh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.fresh.entity.AddrInfo;
import com.yc.fresh.entity.MenberInfo;
import com.yc.fresh.service.IAddressBiz;
import com.yc.fresh.service.ICartInfoService;
import com.yc.fresh.util.ResponseUtil;

@RestController
@RequestMapping("/member")
public class MemberInfoController {
	@Autowired
	private ICartInfoService cartInfoService;
	
	@Autowired
	private IAddressBiz addressBiz;
	/**
	 * 检验用户有没有登录
	 * @param session
	 * @return
	 */
	@GetMapping("/check")
	public Map<String,Object> checkInfo(HttpSession session) {
		Object obj =session.getAttribute("currentLoginMenber");
		if(obj == null) {
			return ResponseUtil.responseMap(500, null, null);
		}
		Map<String,Object>  map= new HashMap<String,Object> ();
		map.put("member", obj);
		MenberInfo mf = (MenberInfo) obj;
		session.setAttribute("cartnum", cartInfoService.findAll(mf.getMno()));
		
		List<AddrInfo> list=addressBiz.findaddr(mf.getMno());
		session.setAttribute("address", list.size());
		
		map.put("carts", cartInfoService.findByMno(mf.getMno()));
		return  ResponseUtil.responseMap(200, null, map);
	}
}
