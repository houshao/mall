package com.atguigu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.bean.T_MALL_SHOPPINGCAR;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.service.CartService;
import com.atguigu.utils.MyJsonUtil;

import org.apache.commons.lang3.StringUtils;
@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	//添加成功后的页面
	@RequestMapping("cart_sucess")
	public String goSuccess(){
		return "sale_cart_sucess";
	}
	//到购物车页面
	@RequestMapping("go_CartList")
	public String cartList(HttpSession session,T_MALL_SHOPPINGCAR cart,HttpServletResponse response ,
			@CookieValue(value="list_cart_cookie",required=false) String list_cart_cookie,ModelMap map){
		List<T_MALL_SHOPPINGCAR> list = null;
		//未登录的时候只查看cookie中的购物车
		T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");
		if(user==null){
			 list = MyJsonUtil.json_to_list(list_cart_cookie,T_MALL_SHOPPINGCAR.class);
			map.put("list_cart", list);
		}else{
			//登录的时候只查看session中的数据库的购物车
			 list = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
		}
		map.put("list_cart", list);
		return "Cart";
		
	}
	
	/**
	 * 迷你购物车
	 * @param session
	 * @return
	 */
	@RequestMapping("minicart")
	public String minicart(HttpSession session,T_MALL_SHOPPINGCAR cart,HttpServletResponse response ,
			@CookieValue(value="list_cart_cookie",required=false) String list_cart_cookie,ModelMap map){
		List<T_MALL_SHOPPINGCAR> list = null;
		//未登录的时候只查看cookie中的购物车
		T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");
		if(user==null){
			 list = MyJsonUtil.json_to_list(list_cart_cookie,T_MALL_SHOPPINGCAR.class);
			map.put("list_cart", list);
		}else{
			//登录的时候只查看session中的数据库的购物车
			 list = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
		}
		map.put("list_cart", list);
		return "sale_cart_miniCartList";
		
	}
	
	/**
	 * list_cart是新的购物车
	 * cart是新添加进来的商品
	 * list_cart_cookie是 cookie中的购物车
	 * list_cart_session是 session中的购物车
	 */
	@RequestMapping("addCard")
	public String addCard(HttpSession session,T_MALL_SHOPPINGCAR cart,HttpServletResponse response ,
			@CookieValue(value="list_cart_cookie",required=false) String list_cart_cookie,ModelMap map){
		List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<>();
		T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");
		//用户未登录
		if(cart.getYh_id()==0){
			//cookie是空的
			if(StringUtils.isBlank(list_cart_cookie)){
				//向cookie中添加购物车数据
				list_cart.add(cart);
			}else{
				list_cart = MyJsonUtil.json_to_list(list_cart_cookie, T_MALL_SHOPPINGCAR.class);
				//判断是否重复
				boolean flag = if_new_cart(list_cart, cart);
				if(flag){
					//如果商品没有重复的话直接添加进去商品集合
					list_cart.add(cart);
				}else{
					for (int i = 0; i < list_cart.size(); i++) {
						//如果添加商品有重复的话向商品集合中重新设置该商品的添加数量 和 金额合计
						if(cart.getSku_id()==list_cart.get(i).getSku_id()){
							list_cart.get(i).setTjshl(list_cart.get(i).getTjshl()+cart.getTjshl());
							list_cart.get(i).setHj(list_cart.get(i).getSku_jg()*list_cart.get(i).getTjshl());
						}
					}
				}
			}
			Cookie cookie = new Cookie("list_cart_cookie",MyJsonUtil.list_to_json(list_cart));
			cookie.setMaxAge(60*60*24*7);
			response.addCookie(cookie);
			//用户已经登陆
		}else {
			list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
			//如果db为空
			if(list_cart== null || list_cart.size()==0){
				//添加db
				boolean flag = cartService.save_cart(cart);
				//更新session
				 list_cart = new ArrayList<T_MALL_SHOPPINGCAR>();
				list_cart.add(cart);
				session.setAttribute("list_cart_session", list_cart);
			//db不是空的
			}else{
				//非重复
				if(if_new_cart(list_cart, cart)){
					//更新数据库和session
					cartService.save_cart(cart);
					list_cart.add(cart);
					session.setAttribute("list_cart_session",MyJsonUtil.list_to_json(list_cart));
				}
				//重复
				else{
					for (int i = 0; i < list_cart.size(); i++) {
						if(list_cart.get(i).getSku_id()==cart.getSku_id()){
							list_cart.get(i).setTjshl(list_cart.get(i).getTjshl()+cart.getTjshl());
							list_cart.get(i).setHj(list_cart.get(i).getTjshl()*list_cart.get(i).getSku_jg());
						}
					}
					//更新数据库和session
					cartService.update_cart(cart);
					list_cart = new ArrayList<T_MALL_SHOPPINGCAR>();
					list_cart.add(cart);
					session.setAttribute("cart_list_session", MyJsonUtil.list_to_json(list_cart));
				}
			}
		}
		return "redirect:/cart_sucess.do";
		
	}
	/*
	 * 对比新添加的商品与购物车中的是否重复
	 */
	public boolean if_new_cart(List<T_MALL_SHOPPINGCAR> list_cart,T_MALL_SHOPPINGCAR cart){
		boolean flag = true;
		for (int i = 0; i < list_cart.size(); i++) {
			if(cart.getSku_id()==list_cart.get(i).getSku_id()){
				flag=false;
			}
		}
		return flag;
	}
}
