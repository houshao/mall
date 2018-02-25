package com.atguigu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.bean.OBJECT_T_MALL_SKU_DETAIL;
import com.atguigu.bean.T_MALL_SKU;
import com.atguigu.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping("goproduct")
	public String goProduct(){
		
		return "sale_product_list";
	}
	@RequestMapping("product")
	public String Product(int sku_id,int spu_id,ModelMap map){
		/*List<OBJECT_T_MALL_SKU_DETAIL> list = productService.getProductList(sku_id);
		map.put("productlist", list);*/
		// sku对象内容
		OBJECT_T_MALL_SKU_DETAIL obj_sku = productService.get_sku_detail(spu_id, sku_id);
		// sku列表内容
		List<T_MALL_SKU> list_sku = productService.get_sku_list_by_spu_id(spu_id);

		map.put("obj_sku", obj_sku);
		map.put("list_sku", list_sku);
		return "sale_search_detail";
	}
	
}
