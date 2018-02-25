package com.atguigu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.T_MALL_ORDER;
import com.atguigu.bean.T_MALL_PRODUCT;
import com.atguigu.service.SpuService;
import com.atguigu.utils.UploadUtil;

@Controller
public class SpuController {
	
	@Autowired
	private SpuService spuService ;
	
	@RequestMapping("gospu")
	public String spuIndex(){
		return "manager_spu";
	}
	
	@RequestMapping("gospuadd")
	public String go_spu_add(){
		return "manager_spu_add";
	}
	
	
	@RequestMapping("spuadd")
	public ModelAndView save_spu(T_MALL_PRODUCT spu, @RequestParam("files") MultipartFile[] files){
		
		//把图片存储起来  返回图片信息
		List<String> list_image = UploadUtil.upload_images(files);
		//向商品表和图片表中插入信息
		spuService.save_Spu(spu,list_image);
		ModelAndView model = new ModelAndView("redirect:/index.do");
		model.addObject("title", "商品信息添加");
		model.addObject("url", "gospuadd.do");
		return model;
	}
}








