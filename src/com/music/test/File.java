package com.music.test;

import com.music.inter.HttpClientKw;

public class File {

	
	
	public static void main(String[] args) throws Exception {
		
		HttpClientKw http  = new HttpClientKw();
		
		http.saveCookie();
		
		http.doPost("http://10.68.170.184:8080/music/api/login", "username=admin&password=123456");

		//上传曲目
//		http.doPostWithMutipart("http://10.68.170.184:8080/music/api/song/upload","{'filePath':'G:\\\\test003.mp3','speed':'1','styleId':'d23b3b0a-78fb-4464-9f2a-a837fcb87281'}");
		//下载曲目
//		http.doGetWithMutipart("http://10.68.170.184:8080/music/api/song/download", "{'musicId':'151521035647193088','filePath':'G:\\\\down\\\\151521035647193088.mp3'}");
//		
//		http.doGetWithMutipart("http://10.68.170.184:8080/music/api/song/download", "{'musicId':'','filePath':'G:\\\\down\\\\151521035647193088.mp3'}");
//	
//		http.doGetWithMutipart("http://10.68.170.184:8080/music/api/song/download", "");
////		
//		http.doGetWithMutipart("http://10.68.170.184:8080/music/api/song/download", "{'musicId':'151521035647193088'}");
//		
		//编辑曲目
//		http.doPutWithJson("http://10.68.170.184:8080/music/api/song/151858711780921344", "{" + 
//				" 'album': '更改名称1',\r\n" + 
//				" 'author': '青蛙',\r\n" + 
//				" 'duration': '02:31',\r\n" + 
//				" 'durationSecond': 151,\r\n" + 
//				" 'id': '151858711780921344',\r\n" + 
//				" 'md5': 'bb68b733538d46492f0aa065ba656ac6',\r\n" + 
//				" 'name': 'testdemo',\r\n" + 
//				" 'referenceCount': 1,\r\n" + 
//				" 'source': 1,\r\n" + 
//				" 'speed': 0,\r\n" + 
//				" 'style': {'id': 'd23b3b0a-78fb-4464-9f2a-a837fcb87281'}" + 
//				"}");
		//删除曲目
//		http.doDeleteWithJson("http://10.68.170.184:8080/music/api/song", "[\"151521033696841728\"]");
		
		//获取曲目信息
		http.doGet("http://10.68.170.184:8080/music/api/song", "&pageNum=1&pageSize=10&currentPage=1&filter=test");
	

	}

}
