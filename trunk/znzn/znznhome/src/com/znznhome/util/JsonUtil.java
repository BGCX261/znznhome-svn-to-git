package com.znznhome.util;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class JsonUtil {
	public static String map2JsonString(Map map) {
		JSONObject jObject = JSONObject.fromObject(map);
		return jObject.toString();
		
	}
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("name", "lxd");
		map.put("age", 15);
		Map map2 = new HashMap();
		map2.put("name", "lyy");
		map2.put("age", 10);
		map.put("sons", map2);
		System.out.println(JsonUtil.map2JsonString(map));
	}
}
