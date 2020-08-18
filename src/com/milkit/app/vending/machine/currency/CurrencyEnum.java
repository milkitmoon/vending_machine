package com.milkit.app.vending.machine.currency;

public enum CurrencyEnum {

	WON("￦", 1), DALLER("$", 1000), YEN("¥", 10);

    private String mark;
    private int exchangeRate;
    

    CurrencyEnum(String mark, int exchange) {
		this.mark = mark;
		this.exchangeRate = exchange;
	}
    
	public String getMark() {		
		return mark;
	}

	public int getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(int exchange) {
		this.exchangeRate = exchange;
	}
	
}
