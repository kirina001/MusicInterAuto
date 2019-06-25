package com.music.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.jayway.jsonpath.JsonPath;
import com.music.inter.KeywordOfInter;

public class TestFile {

	/**
    *
    * @param url 请求URL
    * @param filePath 本地文件地址
    * @return
    */
   public static String upload(String url,String filePath){
       String fdfsPath = "";
       try {

           HttpClient httpclient = new DefaultHttpClient();
           HttpPost httppost = new HttpPost(url);
           File file = new File(filePath);
           String name = file.getName();
           InputStream in = new FileInputStream(file);
           MultipartEntity reqEntity = new MultipartEntity();
           InputStreamBody inputStreamBody = new InputStreamBody(in,name);
           
           StringBody fileNam = new StringBody(name);
           StringBody speed = new StringBody("0");
           StringBody styleId = new StringBody("f893f492-4ff7-4366-87d7-03273ae81da2");
          
//           StringBody position = new StringBody("信息路38",  Charset.forName("utf8"));
           //文件流
           reqEntity.addPart("file", inputStreamBody);
           reqEntity.addPart("fileName", fileNam);
           reqEntity.addPart("speed", speed);
           reqEntity.addPart("styleId", styleId);
          

           httppost.setEntity(reqEntity);
           HttpResponse response = httpclient.execute(httppost);
           int statusCode = response.getStatusLine().getStatusCode();

           if(statusCode == HttpStatus.SC_OK){

               System.out.println("服务器正常响应.....");

               HttpEntity resEntity = response.getEntity();
               System.out.println(EntityUtils.toString(resEntity));//httpclient自带的工具类读取返回数据

               System.out.println(resEntity.getContent());

               EntityUtils.consume(resEntity);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return "";
   }

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		KeywordOfInter http = new KeywordOfInter();
		http.saveCookie();

		String result = http.testPost("http://10.68.170.184:8080/music/api/login", "username=admin&password=123456");
		http.assertSame(result, "登录成功", "$.message");
		
		upload("http://10.68.170.184:8080/music/api/login/music/api/song/upload", "F:\\tes003.mp3");
	}

}
