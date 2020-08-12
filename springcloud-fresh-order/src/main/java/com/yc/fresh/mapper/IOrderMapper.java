package com.yc.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.GoodsInfo;

public interface IOrderMapper {	
	/**
	 * 查找提交的购物车商品信息
	 * @param array
	 * @return
	 */
	public List<GoodsInfo> findCart(String[] array);
	
	/**
	 * 根据cno从购物车中删除商品
	 * @param array
	 * @return
	 */
	public int deleteCart(String[] array);
	
	/**
	 * 更新商品的库存数量
	 * @param list
	 * @return
	 */
	public int updateGoodsNum(List<Map<String,Object>> list);
	
	/**
	 * 添加到订单表
	 * @param map
	 * @return
	 */
	public int addOrderInfo(Map<String,Object> map);
	
	/**
	 * 添加到订单详情表
	 * @param map
	 * @return
	 */
	public int addOrderItem(List<Map<String,Object>> list);
}
