package com.yc.fresh.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.fresh.entity.GoodsInfo;
import com.yc.fresh.mapper.IOrderMapper;
import com.yc.fresh.service.IOrderBiz;
import com.yc.fresh.util.ResponseUtil;
import com.yc.fresh.util.StringUtil;

@Service
public class OrderBizImpl implements IOrderBiz{
	@Autowired
	private IOrderMapper orderMapper;
	
	/**
	 * 提交订单 使用事务
	 * {cno=8,10,12, gno=1,4,7, num=1,2,1, price=6,60,18, totalPrice=84, ano=1, mno=1001}
	 */
	@Transactional
	public Map<String,Object> addOrder(Map<String, Object> map) {
		if(map.get("cno")==null || map.get("gno")==null  || map.get("num")==null  || map.get("price")==null 
				 || map.get("totalPrice")==null  || map.get("ano")==null) {
			return ResponseUtil.responseMap(101, null, null);
		}
		int result=0;
		//1.首先去购物车删除此商品
		String[] cnoArray=map.get("cno").toString().split(",");
		result=orderMapper.deleteCart(cnoArray);
		
		//2.修改goodsinfo表中的库存
		List<Map<String,Object>> param=new ArrayList<Map<String,Object>>();
		Map<String,Object> maps;
		String[] gnos=map.get("gno").toString().split(",");
		String[] nums=map.get("num").toString().split(",");
		String[] price=map.get("price").toString().split(",");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String odate=sdf.format(new Date());//下单时间
		
		String ono=UUID.randomUUID().toString().replace("-", "");
		
		for(int i=0,len=gnos.length;i<len;i++){
			maps=new HashMap<String,Object>();
			maps.put("gno", gnos[i]);
			maps.put("num", nums[i]);
			maps.put("price", price[i]);
			maps.put("ono", ono);
			param.add(maps);
		}
		result=orderMapper.updateGoodsNum(param);
		
		//3.添加信息值订单表
		
		map.put("odate", odate);
		map.put("ono", ono);
		result=orderMapper.addOrderInfo(map);
		
		//4.添加信息到订单详情表
		result=orderMapper.addOrderItem(param);
		
		if(result > 0) {
			return ResponseUtil.responseMap(200, ono, null);
		}
		return ResponseUtil.responseMap(100, null, null);
	}

	@Override
	public List<GoodsInfo> findCart(String cnos) {
		if(StringUtil.checkNull(cnos)){
			return null;
		}
		String[] array=cnos.split(",");
		return orderMapper.findCart(array);
	}

}
