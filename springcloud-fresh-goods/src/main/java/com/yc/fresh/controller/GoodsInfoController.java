package com.yc.fresh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.fresh.entity.GoodsInfo;
import com.yc.fresh.util.RequestParameterUtil;
import com.yc.fresh.service.IGoodsInfoService;

@RestController
@RequestMapping("/goods")
public class GoodsInfoController {
	@Autowired
	private IGoodsInfoService goodsInfoService;
	
	/**
	 * 处理首页商品信息查询请求
	 * @return
	 */
	@RequestMapping(value="/index",method = RequestMethod.GET)
	public Map<String,Object> finds(){
		return goodsInfoService.finds();
	}
	
	@RequestMapping("/detail")
	public GoodsInfo findBygno(Integer gno) {
		 return goodsInfoService.findBygno(gno);
	}
	
	@RequestMapping("/findByPage")
	public List<GoodsInfo> findByPage(@RequestParam Map<String, Object> map){
		return goodsInfoService.findByPage(RequestParameterUtil.pageParam(map));	
	}
	
	@RequestMapping("/findByPageAll")
	public Map<String, Object> findByPageAll(@RequestParam Map<String, Object> map){
		return goodsInfoService.findByPageAll(RequestParameterUtil.pageParam(map));	
	}
}
