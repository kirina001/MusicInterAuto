package com.music.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParse {

	public static void main(String[] args) {
	
		
		String result = "{'username':'cc','nickName':'cc','role':{'id':'1'},'password':'c123456'}" ;  // 一个未转化的字符串
//		String result = "{\"status\":\"0\",\"t\":\"1536912518401\",\"set_cache_time\":\"\",\"data\":[{\"location\":\"北京市北京市 联通\",\"titlecont\":\"IP地址查询\",\"origip\":\"123.123.123.123\",\"origipquery\":\"123.123.123.123\",\"showlamp\":\"1\",\"showLikeShare\":1,\"shareImage\":1,\"ExtendedLocation\":\"\",\"OriginQuery\":\"123.123.123.123\",\"tplt\":\"ip\",\"resourceid\":\"6006\",\"fetchkey\":\"123.123.123.123\",\"appinfo\":\"\",\"role_id\":0,\"disp_type\":0}]}";
		try {
			// 将json字符串转换为map格式
			JSONObject json = new JSONObject(result);
			System.out.println(json);
			System.out.println("json格式：" + json.get("username"));
			Map<String, String> jsonmap = new HashMap<String, String>();
			Iterator<String> jsonit = json.keys();
			while (jsonit.hasNext()) {
				String jsonkey = jsonit.next();
				jsonmap.put(jsonkey, json.get(jsonkey).toString());
			}
//			System.out.println("map格式：" + jsonmap);
			for (String key : jsonmap.keySet()) {
				System.out.println(key + "=" + jsonmap.get(key).toString());
			}

			// 将map中的内容拼接成json字符串
			String s = "{";
			for (String key : jsonmap.keySet()) {
				if (jsonmap.get(key).toString().startsWith("[")) {
					s += "\"" + key + "\":" + jsonmap.get(key).toString() + ",";
				} else {
					s += "\"" + key + "\":\"" + jsonmap.get(key).toString() + "\",";
				}
			}

			s=s.substring(0, s.length()-1)+"}";
			System.out.println(s);
		} catch (JSONException e) {
			
			e.printStackTrace();
		}

	
	}

}
