package com.yc.fresh.mapper;

import java.util.List;

import com.yc.fresh.entity.GoodsType;

public interface IGoodsTypeMapper {
	/**
	 *查找商品类别
	 * @return
	 */
	public List<GoodsType>  finds();
	
}
