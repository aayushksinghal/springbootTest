package com.hackerrank.sample.dto;

public class SortedProducts {
	



	public String getBarCode() {
		return BarCode;
	}

	public void setBarCode(String barCode) {
		BarCode = barCode;
	}

	private String BarCode;
	
	public SortedProducts(String a) {
		BarCode=a;
	}


}