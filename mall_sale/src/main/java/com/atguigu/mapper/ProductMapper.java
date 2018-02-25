package com.atguigu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.bean.OBJECT_T_MALL_SKU_DETAIL;
import com.atguigu.bean.T_MALL_SKU;

public interface ProductMapper {

//	List<OBJECT_T_MALL_SKU_DETAIL> select_product_list(String sku_id);

	
	OBJECT_T_MALL_SKU_DETAIL select_product_list(@Param("spu_id") int spu_id, @Param("sku_id") int sku_id);

	List<T_MALL_SKU> select_sku_list_by_spu_id(int spu_id);

}
