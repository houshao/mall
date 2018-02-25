package com.atguigu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.T_MALL_ATTR_VALUE;
import com.atguigu.bean.T_MALL_OBJECT_SKU_MARK_PRODUCT_IMG;
import com.atguigu.bean.T_MALL_SAV_MODEL;
import com.atguigu.bean.T_MALL_SKU_ATTR_VALUE;
import com.atguigu.mapper.SeachMapper;

	
@Service
public class SeachService {

	@Autowired
	SeachMapper attrMapper;
	public List<T_MALL_ATTR_VALUE> getAttrAndValueList(int id) {
		List<T_MALL_ATTR_VALUE> attrList = attrMapper.selectAttr(id);
		return attrList;
	}
	public List<T_MALL_OBJECT_SKU_MARK_PRODUCT_IMG> getSkuList(int id) {
		List<T_MALL_OBJECT_SKU_MARK_PRODUCT_IMG> list = attrMapper.selectSkuList(id);
		return list;
	}
	public List<T_MALL_OBJECT_SKU_MARK_PRODUCT_IMG> getSkuAtrrList(int id, List<T_MALL_SKU_ATTR_VALUE> list_av) {
		List<T_MALL_OBJECT_SKU_MARK_PRODUCT_IMG> list = new ArrayList<>();
		Map<Object,Object> map = new HashMap<>();
		map.put("class2id",id);
		if(list_av !=null || list_av.size()==0){
			StringBuffer sql = new StringBuffer();
			sql.append(" and sku.id in ");
			sql.append("( select sku0.sku_id from ");
			
			for (int i = 0; i < list_av.size(); i++) {
				 T_MALL_SKU_ATTR_VALUE av = list_av.get(i);
				 sql.append("( select sku_id from t_mall_sku_attr_value where shxm_id = "+av.getShxm_id()+" and shxzh_id = "+av.getShxzh_id()+") sku"+i+"" );
				if(list_av.size()>1&&i<list_av.size()-1){
					sql.append(" , ");
				}
			}
			if(list_av.size()>1){
				sql.append(" where ");
			}
			for (int i = 0; i < list_av.size(); i++) {
				T_MALL_SKU_ATTR_VALUE av = list_av.get(i);
				if(list_av.size()>1&& i<list_av.size()-1){
				sql.append(" sku"+i+".sku_id = sku"+(i+1)+".sku_id ");
				}
				if(list_av.size()>2&& i<list_av.size()-2){
					sql.append(" and ");
				}
			}
			sql.append(" ) ");
			map.put("sql",sql.toString());
		}	
		
		 list = attrMapper.selectSkuAttrList(map);
		return list;
	}
	
	

}
