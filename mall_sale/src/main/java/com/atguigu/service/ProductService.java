package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.OBJECT_T_MALL_SKU_DETAIL;
import com.atguigu.bean.T_MALL_SKU;
import com.atguigu.mapper.ProductMapper;

@Service
public class ProductService {
	@Autowired
	ProductMapper productMapper;
/*
	public List<OBJECT_T_MALL_SKU_DETAIL> getProductList(String sku_id) {
		
		List<OBJECT_T_MALL_SKU_DETAIL> list = productMapper.select_product_list(sku_id);
		
		 return list;
	}
*/

	public OBJECT_T_MALL_SKU_DETAIL get_sku_detail(int spu_id, int sku_id) {
		OBJECT_T_MALL_SKU_DETAIL obj_sku = productMapper.select_product_list(spu_id, sku_id);
		return obj_sku;
	}

	public List<T_MALL_SKU> get_sku_list_by_spu_id(int spu_id) {
		List<T_MALL_SKU> list_sku = productMapper.select_sku_list_by_spu_id(spu_id);
		return list_sku;
	}

}
