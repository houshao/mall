package com.atguigu.mapper;

import java.util.Map;

import com.atguigu.bean.T_MALL_PRODUCT;

public interface SpuMapper {

	void insertProdut(T_MALL_PRODUCT spu);

	void insertProdutImage(Map<String, Object> map);

}