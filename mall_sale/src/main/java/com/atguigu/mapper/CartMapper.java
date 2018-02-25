package com.atguigu.mapper;


import java.util.List;

import com.atguigu.bean.T_MALL_SHOPPINGCAR;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;

public interface CartMapper {

	int insert_cart(T_MALL_SHOPPINGCAR cart);

	int update_cart(T_MALL_SHOPPINGCAR cart);

	List<T_MALL_SHOPPINGCAR> selectCartList(T_MALL_USER_ACCOUNT user);

	T_MALL_USER_ACCOUNT selectUser(T_MALL_USER_ACCOUNT user);

	
	

}
