package com.atguigu.controller;


import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.bean.T_MALL_SHOPPINGCAR;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.service.CartService;
import com.atguigu.service.LoginService;
import com.atguigu.utils.MyJsonUtil;


@Controller
public class IndexController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private CartService cartService;
	
	@RequestMapping("gologin")
	public String login(){
		return "login";
	}
	@RequestMapping("goindex")
	public String index(){
		return "index";
	}
	@RequestMapping("gosale_seach")
	public String sale_seach(){
		return "sale_seach";
	}
	@RequestMapping("goseach_select")
	public String seach_select(){
		return "sale_seach_select";
	}
	@RequestMapping("goseach_area")
	public String seach_area(){
		return "sale_seach_area";
	}
	@RequestMapping("goseach_list")
	public String seach_list(){
		return "sale_seach_attr_list";
	}
	
	@RequestMapping("dologin")
	public String login(@CookieValue(value="list_cart_cookie",required=false )String list_cart_cookie,
			HttpServletResponse response,HttpSession session,T_MALL_USER_ACCOUNT user) throws Exception{
		//认证用户的登陆信息
		Boolean flag = loginService.dologin(user);
		user = cartService.getUserList(user);
		if(flag){
			session.setAttribute("user", user);
		}else{
			return "redirect:/gologin.do";
		}
		Cookie cookie = new Cookie("user",URLEncoder.encode(user.getYh_mch(),"utf-8"));
		cookie.setMaxAge(60*15);
		response.addCookie(cookie);
		
		
		//合并购物车
		List<T_MALL_SHOPPINGCAR> list_cart_db = cartService.getCartList(user);
		List<T_MALL_SHOPPINGCAR> list_cart_cookie_cookie = (List<T_MALL_SHOPPINGCAR>) MyJsonUtil.json_to_list(list_cart_cookie, T_MALL_SHOPPINGCAR.class);
		combine_cart(list_cart_db, list_cart_cookie_cookie, response, session);
		return "redirect:/goindex.do";
	}
	private void combine_cart(List<T_MALL_SHOPPINGCAR> list_cart_db, List<T_MALL_SHOPPINGCAR> list_cart_cookie,
			HttpServletResponse response, HttpSession session) {
		T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");
			//数据库中没有数据  直接循环存入
			if(list_cart_db==null||list_cart_db.size()==0){
				for (int i = 0; i < list_cart_cookie.size(); i++) {
					cartService.save_cart(list_cart_cookie.get(i));
				}
			}else{
			//数据库中有数据  
				for (int i = 0; i < list_cart_cookie.size(); i++) {
					//比较数据库与cookie中是否重复
					boolean flag = if_new_cart(list_cart_db,list_cart_cookie.get(i));
					//不重复的话就直接添加到数据库
					if(flag){
						cartService.save_cart(list_cart_cookie.get(i));
					}else{
					//重复的话就修改数据库和cookie中的数据	
						T_MALL_SHOPPINGCAR cart = new T_MALL_SHOPPINGCAR();
						for (int j = 0; j < list_cart_db.size(); j++) {
							if(list_cart_db.get(j).getSku_id()==list_cart_cookie.get(i).getSku_id()){
								cart = list_cart_db.get(j);
							}
						}
						list_cart_cookie.get(i).setYh_id(cart.getSku_id());
						list_cart_cookie.get(i).setId(cart.getId());
						list_cart_cookie.get(i).setTjshl(cart.getTjshl() + list_cart_cookie.get(i).getTjshl());
						list_cart_cookie.get(i)
								.setHj(list_cart_cookie.get(i).getSku_jg() * list_cart_cookie.get(i).getTjshl());
						cartService.update_cart(list_cart_cookie.get(i));
						
					}
					
				}
			}
			// 清空cookie中的购物车数据，同步sessionresponse.addCookie(new Cookie("list_cart_cookie", ""));
			session.setAttribute("list_cart_session", cartService.getCartList(user));
	}
	
	
	private boolean if_new_cart(List<T_MALL_SHOPPINGCAR> list_cart, T_MALL_SHOPPINGCAR cart) {
		boolean b = true;
		for (int i = 0; i < list_cart.size(); i++) {
			if (cart.getSku_id() == list_cart.get(i).getSku_id()) {
				b = false;
			}
		}
		return b;
	}
}
