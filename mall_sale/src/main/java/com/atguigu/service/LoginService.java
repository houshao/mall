package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.mapper.LoginMapper;

@Service
public class LoginService {
	@Autowired
	private LoginMapper loginMapper;
	public Boolean dologin(T_MALL_USER_ACCOUNT user) {
		int flag = loginMapper.doLogin(user);
		if(flag==0){
			return false;
		}else{
			return true;
		}
	}
}
