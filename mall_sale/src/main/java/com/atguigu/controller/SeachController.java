package com.atguigu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.bean.T_MALL_ATTR_VALUE;
import com.atguigu.bean.T_MALL_OBJECT_SKU_MARK_PRODUCT_IMG;
import com.atguigu.bean.T_MALL_SAV_MODEL;
import com.atguigu.service.SeachService;

@Controller
public class SeachController {
	
	@Autowired
	SeachService attrService;
	
	//加载属性数据和商品信息
	@RequestMapping("loadList")
	public String loadAttrList(int id,Map<String,Object> map){
		List<T_MALL_ATTR_VALUE> attrValueList = attrService.getAttrAndValueList(id);
		List<T_MALL_OBJECT_SKU_MARK_PRODUCT_IMG> skuList = attrService.getSkuList(id);
		map.put("attrList", attrValueList);
		map.put("skuList", skuList);
		map.put("class2id", id);
		return "sale_seach";
	}
	
	//加载属性数据和商品信息
	@RequestMapping("loadSeachList")
	public String loadAttrList(int id,T_MALL_SAV_MODEL list_av, Map<String,Object> map){
		List<T_MALL_OBJECT_SKU_MARK_PRODUCT_IMG> skuAttrList = attrService.getSkuAtrrList(id,list_av.getList_av());
		map.put("skuList", skuAttrList);
		map.put("class2id", id);
		return "sale_seach";
	}
}
