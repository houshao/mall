package com.atguigu.mapper;

import java.util.Map;
import com.atguigu.bean.T_MALL_SKU;

public interface SkuMapper {
	public void insertSKU(T_MALL_SKU sku);

	public void insertSAU(Map<String, Object> map);

}
