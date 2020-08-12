package com.yc.fresh.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.yc.fresh.entity.AddrInfo;
import com.yc.fresh.service.IAddressBiz;

@Controller
@RequestMapping("/addr")
public class AddressController{
	@Autowired
	private IAddressBiz addressBiz ;

	@RequestMapping("/addAddr")
	@ResponseBody
	public int addAddr(@RequestParam Map<String, Object> map,HttpSession session){
		Integer mno=(Integer) session.getAttribute("mno");
		map.put("mno", mno);
		Integer address =(Integer) session.getAttribute("address");
		if(address<1){
			map.put("flag", 1);
			session.setAttribute("address", Integer.parseInt(session.getAttribute("address")+"")+1);
			return addressBiz.addAddr(map);
		}else{
			map.put("flag", 0);
			return addressBiz.addAddr(map);
		}
	}
	
	@RequestMapping("/findaddr")
	@ResponseBody
	public List<AddrInfo> findAddr(@RequestParam Map<String, Object> map,HttpSession session){
		Integer mno=(Integer) session.getAttribute("mno");
		map.put("mno", mno);
		return addressBiz.findaddr(mno);
	}
	
	@RequestMapping("/setDefault")
	@ResponseBody
	public int setDefault(@RequestParam Map<String, Object> map,HttpSession session){
		Integer mno=(Integer) session.getAttribute("mno");
		map.put("mno", mno);
		return addressBiz.setDefault(map);
	}
	
	
}
