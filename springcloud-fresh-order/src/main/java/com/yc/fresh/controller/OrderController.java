package com.yc.fresh.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.fresh.entity.GoodsInfo;
import com.yc.fresh.service.IOrderBiz;

@Controller
@RequestMapping("/order")
public class OrderController{
	@Autowired
	private IOrderBiz orderBiz ;

	@RequestMapping("/findCart")
	@ResponseBody
	public List<GoodsInfo> findCart(String cnos,HttpSession session){
		return orderBiz.findCart(cnos);
	}
	
	@RequestMapping("/pay")
	@ResponseBody
	public Map<String,Object> orderPay(@RequestParam Map<String,Object> map,HttpSession session){
		Integer mno=(Integer) session.getAttribute("mno");
		map.put("mno", mno);
		return orderBiz.addOrder(map);
	}
	
}
