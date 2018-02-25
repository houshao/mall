package com.atguigu.mapper;

import java.util.List;
import java.util.Map;

import com.atguigu.bean.T_MALL_ATTR_VALUE;
import com.atguigu.bean.T_MALL_OBJECT_SKU_MARK_PRODUCT_IMG;

public interface SeachMapper {

	List<T_MALL_ATTR_VALUE> selectAttr(int id);

	List<T_MALL_OBJECT_SKU_MARK_PRODUCT_IMG> selectSkuList(int id);

	List<T_MALL_OBJECT_SKU_MARK_PRODUCT_IMG> selectSkuAttrList(Map<Object, Object> map);

}
