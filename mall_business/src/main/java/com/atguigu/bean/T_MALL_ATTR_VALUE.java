package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class T_MALL_ATTR_VALUE extends T_MALL_ATTR{

	private List<T_MALL_VALUE> list_value = new ArrayList<>();

	public List<T_MALL_VALUE> getList_value() {
		return list_value;
	}

	public void setList_value(List<T_MALL_VALUE> list_value) {
		this.list_value = list_value;
	}
	
	
}
