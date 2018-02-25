package com.atguigu.bean;

public class T_MALL_OBJECT_SKU_MARK_PRODUCT_IMG extends T_MALL_SKU{
	
	T_MALL_PRODUCT_IMAGE image;	
	T_MALL_PRODUCT product;
	T_MALL_TRADE_MARK mark;
	
	public T_MALL_PRODUCT_IMAGE getImage() {
		return image;
	}
	public void setImage(T_MALL_PRODUCT_IMAGE image) {
		this.image = image;
	}
	public T_MALL_PRODUCT getProduct() {
		return product;
	}
	public void setProduct(T_MALL_PRODUCT product) {
		this.product = product;
	}
	public T_MALL_TRADE_MARK getMark() {
		return mark;
	}
	public void setMark(T_MALL_TRADE_MARK mark) {
		this.mark = mark;
	}

}