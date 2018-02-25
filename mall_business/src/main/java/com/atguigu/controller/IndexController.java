package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("index")
	public String Index(String url,String title,ModelMap map){
		map.put("title", title);
		map.put("url", url);
		return "manager_index";
	}
}
