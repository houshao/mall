package com.atguigu.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

import com.aliyun.api.gateway.demo.util.HttpUtils;


public class Photo {
		public static void main(String[] args) {
		    String host = "https://dm-71.data.aliyun.com";
		    String path = "/rest/160601/int_image/matting.json";
		    String method = "POST";
		    String appcode = "59da108a6aaa40819960280a696d42c9";
		    Map<String, String> headers = new HashMap<String, String>();
		    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		    headers.put("Authorization", "APPCODE " + appcode);
		    //根据API的要求，定义相对应的Content-Type
		    headers.put("Content-Type", "application/json; charset=UTF-8");
		    Map<String, String> querys = new HashMap<String, String>();
		    String bodys = "{\"image\":{\"dataType\":10,\"dataValue\":\"图片以Base64编码的字符串\"}}";


		    try {
		    	/**
		    	* 重要提示如下:
		    	* HttpUtils请从
		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
		    	* 下载
		    	*
		    	* 相应的依赖请参照
		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
		    	*/
		    	HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
		    	System.out.println(response.toString());
		    	//获取response的body
		    	//System.out.println(EntityUtils.toString(response.getEntity()));
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		}
	}
