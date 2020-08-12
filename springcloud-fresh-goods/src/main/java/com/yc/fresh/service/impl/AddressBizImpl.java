package com.yc.fresh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.entity.AddrInfo;
import com.yc.fresh.mapper.IAddressMapper;
import com.yc.fresh.service.IAddressBiz;

@Service
public class AddressBizImpl implements IAddressBiz{
	@Autowired
	private IAddressMapper mapper;

	@Override
	public List<AddrInfo> findaddr(Integer mno) {
		return mapper.findaddr(mno);
	}

}
