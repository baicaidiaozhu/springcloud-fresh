package com.yc.fresh.service;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.AddrInfo;

public interface IAddressBiz {
	/**
	 * 添加地址
	 * @param map
	 * @return
	 */
	public int addAddr(Map<String,Object> map);
	
	/**
	 * 查询所有地址信息
	 * @param mno
	 * @return
	 */
	public List<AddrInfo> findaddr(Integer mno);
	
	
	/**
	 * 设置默认地址
	 * @param map
	 * @return
	 */
	public int setDefault(Map<String,Object> map);
}
