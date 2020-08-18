package com.milkit.app.vending.machine.product;

import com.milkit.app.util.NumberUtil;
import com.milkit.app.vending.machine.currency.CurrencyEnum;

public class Product {

	private String productCD;
	private String productNM;
	private int price;
	
	public Product(String productCD, String productNM, int price) {
		this.productCD = productCD;
		this.productNM = productNM;
		this.price = price;
	}
	
	
	public String getProductCD() {
		return productCD;
	}
	public void setProductCD(String productCD) {
		this.productCD = productCD;
	}
	public String getProductNM() {
		return productNM;
	}
	public void setProductNM(String productNM) {
		this.productNM = productNM;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(productCD).append(") ").append(productNM).append("(").append(CurrencyEnum.WON.getMark()).append(NumberUtil.addComma(price)).append(")");
		
		return builder.toString();
	}
	
}
