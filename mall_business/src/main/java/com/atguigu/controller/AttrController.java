package com.atguigu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.T_MALL_ATTR_VALUE;
import com.atguigu.bean.T_MALL_ATTR_VALUE_MODEL;
import com.atguigu.service.AttrService;

@Controller
public class AttrController {
	
	@Autowired
	AttrService attrService;
	
	@RequestMapping("goattr")
	public String go_attr(){
		return "manager_attr";
	}
	@RequestMapping("goaddattr")
	public String go_addAttr(String name,String id ,ModelMap map){
		map.put("name", name);
		map.put("id", id);
		System.out.println(name+id);
		return "manager_attr_add";
	}
	@RequestMapping("addattr")
	public String addAttr(T_MALL_ATTR_VALUE_MODEL model,String calss2name,int class2id){
		//把数据保存到数据库
		attrService.sava_attr_value(model.getList(),class2id);
		return "manager_attr_add";
	}
	
	//显示属性列表  异步返回页面 绑定入参返回map的形式加载数据
	@RequestMapping("attr")
	public String attr_List(int id,Map<String,Object> map){
		List<T_MALL_ATTR_VALUE> attrValueList = attrService.getAttrAndValueList(id);
		map.put("attrList", attrValueList);
		return "manager_attr_view";
	}
	//显示属性列表   异步加载json easyui插件加载数据的方式 
	@ResponseBody
	@RequestMapping("/attrvalue")
	public Object attrView_List(int id){
		List<T_MALL_ATTR_VALUE> attrValueList = attrService.getAttrAndValueList(id);
		return attrValueList;
	}
}
