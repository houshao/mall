package com.atguigu.threadAuxiliary;

public enum Country {
	
	ONE(1,"齐国"),TWO(2,"楚国"),THREE(3,"燕国"),FIVE(4,"赵国"),SIX(5,"魏国"),SEVEN(6,"韩国");
	
	private int index ;
	private String countryName;
	private Country(int index, String countryName) {
		this.index = index;
		this.countryName = countryName;
	}
	private Country() {
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public static Country getCountry(int index) {
		for (Country element : values()) {
			if(element.getIndex()==index){
				return element;
			}
		} 
		return null;
	}
	

}
