package com.yc.fresh.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.fresh.service.ICartInfoService;

@Controller
@RequestMapping("/cart")
public class CartInfoController{
	@Autowired
	private ICartInfoService cartBiz ;
	

	@RequestMapping("/add")
	@ResponseBody
	public int addCart(@RequestParam Map<String,Object> map,HttpSession session) {
		return cartBiz.addgoods(map);
		
	}
	
	@RequestMapping("/updates")
	@ResponseBody
	public int update(@RequestParam Map<String,Object> map,HttpSession session) {
		return cartBiz.updatenum(map);
		
	}
	
	@RequestMapping("/findAlls")
	@ResponseBody
	public List<Map<String, Object>> findAlls(HttpSession session){
		Integer mno=(Integer) session.getAttribute("mno");
		return cartBiz.findAlls(mno);
		
	}
	
	@RequestMapping("/changeGoodsNum")
	@ResponseBody
	public int changeGoodsNum(@RequestParam Map<String,Object> map,HttpSession session){
		Integer mno=(Integer) session.getAttribute("mno");
		map.put("mno", mno);
		return cartBiz.updatenum(map);
	}
	
	@RequestMapping("/delGoods")
	@ResponseBody
	public int delGoods(@RequestParam Map<String,Object> map,HttpSession session){
		Integer mno=(Integer) session.getAttribute("mno");
		map.put("mno", mno);
		
		return cartBiz.delGoods(map);
	}
}
