package com.yc.fresh.service;

import java.util.List;

import com.yc.fresh.entity.OrderInfo;


public interface IOrderItemBiz {
	/**
	 * 查询购买的商品信息
	 * @param mno
	 * @return
	 */
	public  List<OrderInfo> findOrderItem(Integer mno);
	
	/**
	 * 根据订单号修改order表状态
	 * 0，未支付
	 * 1，已支付
	 * 2，已发货
	 * @param ono
	 * @return
	 */
	public int update(String ono);
	
	/**
	 * 根据订单号修改orderitem表状态
	 * 0，未支付
	 * 1，已支付
	 * 2，已发货
	 * @param ono
	 * @return
	 */
	public int updateItem(String ono);
}
