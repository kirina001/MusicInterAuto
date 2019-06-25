package com.music.test;

import com.jayway.jsonpath.JsonPath;
import com.music.inter.KeywordOfInter;

public class TestInter {

	public static void main(String[] args) {
		
		KeywordOfInter http = new KeywordOfInter();
		http.saveCookie();
		
		String result = http.testPost("http://10.68.170.184:8080/music/api/login", "username=admin&password=123456");
		http.assertSame(result, "登录成功", "$.message");
		String id=JsonPath.read(result, "$.result");
		
		String result1=http.testGet("http://10.68.170.184:8080/music/api/user/"+id, "");
		http.assertSame(result1, "0", "$.code");
		
		String str = "{'username':'cc','nickName':'cc','role':{'id':'1'},'password':'c123456'}" ;  // 一个未转化的字符串
	    String result2=http.testPostJson("http://10.68.170.184:8080/music/api/user",str);
	    http.assertSame(result2, "0", "$.code");
		
		
	
		

	}

}
