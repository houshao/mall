package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.T_MALL_ATTR;
import com.atguigu.bean.T_MALL_ATTR_VALUE;
import com.atguigu.mapper.AttrMapper;

	
@Service
public class AttrService {

	@Autowired
	AttrMapper attrMapper;
//	public List<T_MALL_ATTR> getAttrList(int id) {
//		List<T_MALL_ATTR> attrList = attrMapper.selectAttr(id);
//		return attrList;
//	}
	public List<T_MALL_ATTR_VALUE> getAttrAndValueList(int id) {
		List<T_MALL_ATTR_VALUE> attrList = attrMapper.selectAttr(id);
		return attrList;
	}
	public void sava_attr_value(List<T_MALL_ATTR_VALUE> list, int class2id) {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setFlbh2(class2id);
			attrMapper.insert_attr(class2id,list.get(i));
			
			attrMapper.insert_value(list.get(i).getId(),list.get(i).getList_value());
			
		}
	}
	
	

}
