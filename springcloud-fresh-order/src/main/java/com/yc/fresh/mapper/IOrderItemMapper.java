package com.yc.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.OrderInfo;


public interface IOrderItemMapper {	
	/**
	 * 查询用户购买商品的编号
	 * @param mno
	 * @return
	 */
	public List<Integer>  findgno(Integer mno);
	
	/**
	 * 查询购买的商品信息
	 * @param map
	 * @return
	 */
	public  List<OrderInfo> findOrderItem(Map<String,Object> map);
	
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
