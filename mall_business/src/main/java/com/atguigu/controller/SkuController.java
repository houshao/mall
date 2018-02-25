package com.atguigu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.bean.T_MALL_ATTR_VALUE;
import com.atguigu.bean.T_MALL_ATTR_VALUE_SKU_MODLE;
import com.atguigu.bean.T_MALL_SKU;
import com.atguigu.service.AttrService;
import com.atguigu.service.SkuService;

@Controller
public class SkuController {
	@Autowired
	AttrService attrService;
	@Autowired
	SkuService skuService;
	
	@RequestMapping("gosku")
	public String gotosku(){
		return "manager_sku";
	}
	@RequestMapping("sku")
	public String sku(int id,ModelMap map){
		List<T_MALL_ATTR_VALUE> attrAndValueList = attrService.getAttrAndValueList(id);
		map.put("attrAndValueList", attrAndValueList);
		return "manager_sku_view";
	}
	@RequestMapping("addsku")
	public String addsku(T_MALL_ATTR_VALUE_SKU_MODLE model ,T_MALL_SKU sku){
		skuService.saveSku(model,sku);
		return "manager_sku_view";
	}
	
	

}
