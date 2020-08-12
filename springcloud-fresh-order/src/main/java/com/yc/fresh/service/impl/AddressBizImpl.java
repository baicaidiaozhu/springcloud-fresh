package com.yc.fresh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.entity.AddrInfo;
import com.yc.fresh.mapper.IAddressMapper;
import com.yc.fresh.service.IAddressBiz;
import com.yc.fresh.util.StringUtil;

@Service
public class AddressBizImpl implements IAddressBiz{
	@Autowired
	private IAddressMapper mapper;

	@Override
	public int addAddr(Map<String, Object> map) {
		if(StringUtil.checkNull(map.get("mno"),map.get("name"),map.get("tel"),map.get("province"),map.get("city"),
				map.get("area"),map.get("addr"),map.get("flag"))){
			return -1;
		}
		return mapper.addAddr(map);
	}

	@Override
	public List<AddrInfo> findaddr(Integer mno) {
		return mapper.findaddr(mno);
	}


	@Override
	public int setDefault(Map<String, Object> map) {
		if(StringUtil.checkNull(map.get("ano"))){
			return -1;
		}
		return mapper.setDefault(map);
	}
}
