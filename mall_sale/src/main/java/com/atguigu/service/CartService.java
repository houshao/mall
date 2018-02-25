package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.FlashMap;

import com.atguigu.bean.T_MALL_SHOPPINGCAR;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.mapper.CartMapper;

@Service
public class CartService {
	@Autowired
	CartMapper catmapping;
	
	/*
	 * 添加购物车到数据库
	 */
	public boolean save_cart(T_MALL_SHOPPINGCAR cart) {
		int i  = catmapping.insert_cart(cart);
		if(i==0){
			return false;
		}else
		return true;
	}
	public boolean update_cart(T_MALL_SHOPPINGCAR cart) {
		int i  = catmapping.update_cart(cart);
		if(i==0){
			return false;
		}else
		return true;
	}
	public T_MALL_USER_ACCOUNT getUserList(T_MALL_USER_ACCOUNT user){
		 user = catmapping.selectUser(user);
		
		return user;
	}
	
	public List<T_MALL_SHOPPINGCAR> getCartList(T_MALL_USER_ACCOUNT user) {
		
		 user = getUserList(user);
		 List<T_MALL_SHOPPINGCAR> list = catmapping.selectCartList(user);
		return list;
	}

}
