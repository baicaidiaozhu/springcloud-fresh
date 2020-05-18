package com.yc.fresh.service;

import java.util.Map;

import com.yc.fresh.entity.MenberInfo;

public interface IMenberInfoBiz {
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
