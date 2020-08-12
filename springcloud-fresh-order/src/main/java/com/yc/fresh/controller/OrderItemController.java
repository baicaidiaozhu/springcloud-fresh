package com.yc.fresh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.fresh.entity.OrderInfo;
import com.yc.fresh.service.IOrderItemBiz;


@Controller
@RequestMapping("/orderItem")
public class OrderItemController{
	@Autowired
	private IOrderItemBiz orderItemBiz ;

	
	@RequestMapping("/findshow")
	@ResponseBody
	public List<OrderInfo> findshow(HttpSession session){
		Integer mno=(Integer) session.getAttribute("mno");
		return orderItemBiz.findOrderItem(mno);
	}
	
}
