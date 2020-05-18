package com.yc.fresh.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.entity.MenberInfo;
import com.yc.fresh.mapper.IMenberInfoMapper;
import com.yc.fresh.service.IMenberInfoBiz;
import com.yc.fresh.util.StringUtil;

@Service
public class MenberInfoBizImpl implements IMenberInfoBiz{
	@Autowired
	private IMenberInfoMapper mapper;
	
	@Override
	public MenberInfo login(MenberInfo me) {
		if(StringUtil.checkNull(me.getNickName(),me.getPwd())){
			return null;
		}
		return mapper.login(me);
	}

	@Override
	public int reg(Map<String, String> map) {
		if(StringUtil.checkNull(map.get("email"),map.get("nickName"),map.get("pwd"),map.get("tel"))){
			return -1;
		}
		return mapper.reg(map);
	}
	

}
