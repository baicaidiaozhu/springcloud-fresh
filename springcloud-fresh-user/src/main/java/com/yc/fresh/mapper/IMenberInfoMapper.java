package com.yc.fresh.mapper;

import java.util.Map;

import com.yc.fresh.entity.MenberInfo;

public interface IMenberInfoMapper {
	/**
	 * 用户登录
	 * @param me
	 * @return
	 */
	public MenberInfo login(MenberInfo me);
	
	/**
	 * 注册
	 * @param map
	 * @return
	 */
	public int reg(Map<String,String> map);
	
}
