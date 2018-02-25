package com.atguigu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.T_MALL_PRODUCT;
import com.atguigu.mapper.SpuMapper;

@Service
public class SpuService {
	@Autowired
	private SpuMapper spuMapper;
	public void save_Spu(T_MALL_PRODUCT spu, List<String> list_image) {
		Map<String,Object> map = new HashMap<String,Object>();
		spuMapper.insertProdut(spu);
		
		//插入商品图片信息
		map.put("spu",spu);
		map.put("list_image",list_image);
		spuMapper.insertProdutImage(map);
		
	}
}
