package com.yc.fresh.service;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.GoodsInfo;



public interface IOrderBiz {
	/**
	 * 添加订单
	 * @param map
	 * @return
	 */
	public Map<String,Object> addOrder(Map<String,Object> map);
	
	/**
	 * 查找提交的购物车商品信息
	 * @param map
	 * @return
	 */
	public List<GoodsInfo> findCart(String cnos);
}
