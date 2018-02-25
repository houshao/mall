package com.atguigu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.T_MALL_ATTR_VALUE_SKU_MODLE;
import com.atguigu.bean.T_MALL_SKU;
import com.atguigu.bean.T_MALL_SKU_ATTR_VALUE;
import com.atguigu.mapper.SkuMapper;
@Service
public class SkuService {
	@Autowired
	SkuMapper skumapper;
	public void saveSku(T_MALL_ATTR_VALUE_SKU_MODLE model, T_MALL_SKU sku) {
		Map<String,Object> map = new HashMap<>();
		skumapper.insertSKU(sku);
		map.put("model", model.getList());
		map.put("skuid", sku.getId());
		map.put("spuid", sku.getShp_id());
		skumapper.insertSAU(map);
	}

}
