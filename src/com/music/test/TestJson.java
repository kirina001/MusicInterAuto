package com.music.test;

import com.music.inter.HttpClientKw;

public class TestJson {
	

    
    public static void main(String[] args) throws Exception {
    	
    	HttpClientKw http = new HttpClientKw();
    	http.saveCookie();
    	http.doPost("http://10.68.170.184:8080/music/api/login", "username=admin&password=123456");
        String str = "{'username':'cc','nickName':'cc','role':{'id':'1'},'password':'c123456'}" ;  // 一个未转化的字符串
    	http.doPostWithJson("http://10.68.170.184:8080/music/api/user",str);
        
	
    }
}
