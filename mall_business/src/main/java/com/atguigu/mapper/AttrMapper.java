package com.atguigu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.bean.T_MALL_ATTR;
import com.atguigu.bean.T_MALL_ATTR_VALUE;
import com.atguigu.bean.T_MALL_VALUE;

public interface AttrMapper {

	List<T_MALL_ATTR_VALUE> selectAttr(int id);

	void insert_attr(@Param("class2id")int class2id, @Param("attr")T_MALL_ATTR_VALUE list);
	void insert_value(@Param("attr_id")int id, @Param("list_value")List<T_MALL_VALUE> list_value);

}
