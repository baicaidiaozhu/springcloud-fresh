package com.yc.fresh.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求处理类
 *源辰信息
 * @author LiuJie
 * @date 2020年5月16日
 */
public class RequestParameterUtil {
	public static Map<String,Object> pageParam(Integer page,Integer rows){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		return map;
	}
	public static Map<String,Object> pageParam(Integer page,Integer rows,Integer tno){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		map.put("tno", tno);
		return map;
	}
	
	public static Map<String,Object> pageParam(Map<String,Object> map){
		int page = Integer.parseInt(String.valueOf(map.get("page")));
		int rows = Integer.parseInt(String.valueOf(map.get("rows")));
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		return map;
	}
}
