package com.yc.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.GoodsInfo;

public interface IGoodsInfoMapper {
	/**
	 * 首页查询,查询每种商品类型的最新4条数据
	 * @return
	 */
	public List<GoodsInfo> finds();

	/**
	 * 根据商品编号查询商品
	 * @param gds
	 * @return
	 */
	public GoodsInfo findBygno(Integer gno);
	
	/**
	 * 根据类别查找商品总数
	 * @param tno
	 * @return
	 */
	public int total(Integer tno);
	
	/**
	 * 按类别分类查找
	 * @param map
	 * @return
	 */
	public List<GoodsInfo> findByPage(Map<String,Object> map);
	
	/**
	 * 根据购物车编号修改商品库存的方法
	 * @param cno
	 * @return
	 */
	public int updateStore(String[] cno);
}
