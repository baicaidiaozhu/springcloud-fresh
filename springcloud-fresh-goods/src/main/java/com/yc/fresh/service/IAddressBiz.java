package com.yc.fresh.service;

import java.util.List;

import com.yc.fresh.entity.AddrInfo;


public interface IAddressBiz {
	/**
	 * 查询所有地址信息
	 * @param mno
	 * @return
	 */
	public List<AddrInfo> findaddr(Integer mno);
}
