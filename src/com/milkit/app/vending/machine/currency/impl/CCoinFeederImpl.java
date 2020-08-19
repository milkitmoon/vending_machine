package com.milkit.app.vending.machine.currency.impl;

import java.util.ArrayList;
import java.util.List;

import com.milkit.app.vending.machine.currency.AbstractCurrencyFeederImpl;
import com.milkit.app.vending.machine.currency.Currency;
import com.milkit.app.vending.machine.currency.CurrencyEnum;

public class CCoinFeederImpl extends AbstractCurrencyFeederImpl  {

	@Override
	public List<Currency> generateCurrencyList() {
		List<Currency> currencyList = new ArrayList<Currency>();
		currencyList.add(new Currency(CurrencyEnum.WON, 100));
		
		return currencyList;
	}


}
