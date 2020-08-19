package com.milkit.app.vending.machine.currency.impl;

import java.util.ArrayList;
import java.util.List;

import com.milkit.app.vending.machine.currency.AbstractCurrencyFeederImpl;
import com.milkit.app.vending.machine.currency.Currency;
import com.milkit.app.vending.machine.currency.CurrencyEnum;
import com.milkit.app.vending.machine.currency.CurrencyFeeder;

public class ABillFeederImpl extends AbstractCurrencyFeederImpl {

	@Override
	public List<Currency> generateCurrencyList() {
		List<Currency> currencyList = new ArrayList<Currency>();
		currencyList.add(new Currency(CurrencyEnum.WON, 1000));
		currencyList.add(new Currency(CurrencyEnum.WON, 5000));
		currencyList.add(new Currency(CurrencyEnum.WON, 10000));
		currencyList.add(new Currency(CurrencyEnum.WON, 50000));
		
		return currencyList;
	}
	

}
