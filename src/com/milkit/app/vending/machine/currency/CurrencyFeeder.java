package com.milkit.app.vending.machine.currency;

import java.util.List;

public interface CurrencyFeeder {

	public List<Currency> getCurrencyList();

	public boolean containsCurrency(int amount);
	
/*	
	public int getRcvAmount();
	
	public void addRcvAmount(CurrencyEnum currencyEnum, int rcvAmount);
*/
}
