package com.yc.fresh.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.entity.OrderInfo;
import com.yc.fresh.mapper.IOrderItemMapper;
import com.yc.fresh.service.IOrderItemBiz;
import com.yc.fresh.util.StringUtil;


@Service
public class OrderItemBizImpl implements IOrderItemBiz{
	@Autowired
	private IOrderItemMapper orderItemMapper;

	@Override
	public  List<OrderInfo> findOrderItem(Integer mno) {
		List<Integer> list =orderItemMapper.findgno(mno);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("mno", mno);
		return orderItemMapper.findOrderItem(map);
	}

	@Override
	public int update(String ono) {
		if(StringUtil.checkNull(ono)){
			return -1;
		}
		return orderItemMapper.update(ono);
	}

	@Override
	public int updateItem(String ono) {
		if(StringUtil.checkNull(ono)){
			return -1;
		}
		return orderItemMapper.updateItem(ono);
	}
	
}
