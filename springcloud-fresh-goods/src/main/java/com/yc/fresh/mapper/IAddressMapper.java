package com.yc.fresh.mapper;

import java.util.List;

import com.yc.fresh.entity.AddrInfo;


public interface IAddressMapper {
	/**
	 * 查询所有地址信息
	 * @param mno
	 * @return
	 */
	public List<AddrInfo> findaddr(Integer mno);
	
}
