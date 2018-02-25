package com.atguigu.mapper;

import java.util.List;

import com.atguigu.bean.T_MALL_CLASS_1;
import com.atguigu.bean.T_MALL_CLASS_2;
import com.atguigu.bean.T_MALL_TRADE_MARK;

public interface ClassMapper {
	/**
	 * 获取一级列表
	 * @return
	 */
	public List<T_MALL_CLASS_1> select_class_1();
	/**
	 * 获取根据一级id获取二级列表
	 * @param id
	 * @return
	 */
	public List<T_MALL_CLASS_2> select_class_2ByClass_1_id(int id);
	
	/**
	 * 获取根据一级菜单获取品牌信息
	 * @param id
	 * @return
	 */
	public List<T_MALL_TRADE_MARK> select_trade_markByClass_1_id(int id);
	/**
	 * 根据品牌id获取商品信息
	 * @param id
	 * @return
	 */
	public List<T_MALL_TRADE_MARK> select_spu_ByTrade_mark(int id);
	
 }
