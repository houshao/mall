package com.atguigu.utils;

import java.io.IOException;
import java.util.Properties;
/**
 * 配置文件中读取数据的工具类
 * @author SSPC
 */
public class MyPropertisUtil {
	public static String getMyPath(String pname, String key) {
		Properties property = new Properties();
		try {
			property.load(MyPropertisUtil.class.getClassLoader().getResourceAsStream(pname));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = property.getProperty(key);
		return value;
	}

}
