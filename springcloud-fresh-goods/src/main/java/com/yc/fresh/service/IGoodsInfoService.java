package com.yc.fresh.service;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.GoodsInfo;

public interface IGoodsInfoService {
	/**
	 * 首页查询,查询每种商品类型的最新4条数据以及所有商品类型
	 * @return
	 */
	public Map<String,Object> finds();
	
	/**
	 * 按类别分类查找
	 * @param map
	 * @return
	 */
	public List<GoodsInfo> findByPage(Map<String,Object> map);
	
	/**
	 * 根据商品编号查询商品
	 * @param gds
	 * @return
	 */
	public GoodsInfo findBygno(Integer gds);
	
	/**
	 * 分页查询所有的商品信息
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String,Object> findByPageAll(Map<String,Object> map);
}
