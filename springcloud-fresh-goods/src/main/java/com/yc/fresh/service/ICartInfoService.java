package com.yc.fresh.service;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.CartInfo;

public interface ICartInfoService {
	/**
	 * 按商品gno查找商品
	 * @param map
	 * @return
	 */
	public List<CartInfo> findBygno(Map<String,Object> map);
	
	/**
	 * 添加商品到购物车
	 * @param ca
	 * @return
	 */
	public int addgoods(Map<String,Object> map);
	
	/**
	 * 更新商品数量
	 * @param map
	 * @return
	 */
	public int updatenum(Map<String,Object> map);
	
	/**
	 * 查找购物车数量
	 * @param mno
	 * @return
	 */
	public int findAll(Integer mno);
	
	/**
	 * 查询购物车中的所有商品
	 * @param mno
	 * @return
	 */
	public List<Map<String,Object>> findAlls(Integer mno);
	
	/**
	 * 删除购物车商品
	 * @param map
	 * @return
	 */
	public int delGoods(Map<String,Object> map);
	
	/**
	 * 根据会员编号查询购物车详细信息
	 * @param mno
	 * @return
	 */
	public List<Map<String,Object>> findByMno(Integer mno);
}
