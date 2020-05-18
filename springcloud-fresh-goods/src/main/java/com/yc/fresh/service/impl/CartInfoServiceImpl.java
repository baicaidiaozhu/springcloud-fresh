package com.yc.fresh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yc.fresh.entity.CartInfo;
import com.yc.fresh.mapper.ICartMapper;
import com.yc.fresh.service.ICartInfoService;
import com.yc.fresh.util.StringUtil;

@Service
public class CartInfoServiceImpl implements ICartInfoService{
	@Autowired
	private ICartMapper mapper;

	@Override
	public List<CartInfo> findBygno(Map<String, Object> map) {
		if(StringUtil.checkNull(map.get("mno"),map.get("gno"))){
			return null;
		}
		return mapper.findBygno(map);
	}


	@Override
	public int addgoods(Map<String,Object> map) {
		if(StringUtil.checkNull(map.get("mno"),map.get("gno"),map.get("num"))){
			return -1;
		}
		return mapper.addgoods(map);
	}


	@Override
	public int updatenum(Map<String, Object> map) {
		if(StringUtil.checkNull(map.get("cno"),map.get("num"))){
			return -1;
		}
		return mapper.updatenum(map);
	}


	@Override
	public int findAll(Integer mno) {
		return mapper.findAll(mno);
	}


	@Override
	public List<Map<String, Object>> findAlls(Integer mno) {
		return mapper.findAlls(mno);
	}


	@Override
	public int delGoods(Map<String, Object> map) {
		if(StringUtil.checkNull(map.get("cno"))){
			return -1;
		}
		return mapper.delGoods(map);
	}


	@Override
	public List<Map<String, Object>> findByMno(Integer mno) {
		return mapper.findByMno(mno);
	}

}
