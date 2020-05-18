package com.yc.fresh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.entity.GoodsInfo;
import com.yc.fresh.mapper.IGoodsInfoMapper;
import com.yc.fresh.mapper.IGoodsTypeMapper;
import com.yc.fresh.service.IGoodsInfoService;

@Service
public class GoodsInfoServiceImpl implements IGoodsInfoService{
	@Autowired
	private IGoodsInfoMapper goodsInfoMapper;
	
	@Autowired
	private IGoodsTypeMapper goodstypeMapper;
	
	/**
	 * 返回所有商品类型信息和每种类型的最新4条商品信息
	 */
	@Override
	public Map<String, Object> finds() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("types", goodstypeMapper.finds()); //所有商品类型信息存到types里面
		map.put("goods", goodsInfoMapper.finds()); //4条最新数据存到goods中
		return map;
	}

	@Override
	public List<GoodsInfo> findByPage(Map<String, Object> map) {
		return  goodsInfoMapper.findByPage(map);
	}

	@Override
	public GoodsInfo findBygno(Integer gno) {
		return goodsInfoMapper.findBygno(gno);
	}

	@Override
	public Map<String, Object> findByPageAll(Map<String, Object> map) {
		int total = goodsInfoMapper.total(Integer.parseInt((String) map.get("tno")));
		Map<String, Object>  result = new HashMap<String, Object> ();
		result.put("total", total);
		result.put("goods", this.findByPage(map));
		return result;
	}

}
