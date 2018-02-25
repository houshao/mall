package com.atguigu.factory;

import com.google.gson.Gson;

public class GetJson {
	public static void main(String[] args) {
		Gson gson = new Gson();
		String str = "123";
		String json = gson.toJson(str);
		System.out.println(json);
	}
	
}
