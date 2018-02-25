package com.atguigu.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

import com.aliyun.api.gateway.demo.util.HttpUtils;


public class Ip {
	public static void main(String[] args) {
	    String host = "http://saip.market.alicloudapi.com";
	    String path = "/ip";
	    String method = "GET";
	    String appcode = "59da108a6aaa40819960280a696d42c9";
	    Map<String, String> headers = new HashMap<String, String>();
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("ip", "120.24.72.80");


	    try {
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	System.out.println(response.toString());
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}	
	
}
