package com.milkit.app.vending.machine.currency;

import com.milkit.app.util.NumberUtil;

public class Currency {

	private CurrencyEnum currency = CurrencyEnum.WON;
	private int amount;
	
	
	
	public Currency(CurrencyEnum currency, int amount) {
		this.currency = currency;
		this.amount = amount;
	}
	
	public CurrencyEnum getCurrency() {
		return currency;
	}
	public void setCurrency(CurrencyEnum currency) {
		this.currency = currency;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(currency.getMark()).append(NumberUtil.addComma(amount));
		
		return builder.toString();
	}

	
}
