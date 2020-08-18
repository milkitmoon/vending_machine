package com.milkit.app.vending.machine.currency;

import java.util.List;

import com.milkit.app.vending.exception.SystemException;

public abstract class AbstractCurrencyFeederImpl implements CurrencyFeeder {
	
	private List<Currency> currencyList;
	private int rcvAmount;
	
	abstract public List<Currency> generateCurrencyList();
	
	
	public AbstractCurrencyFeederImpl() {
		currencyList = generateCurrencyList();
	}
	
/*
	@Override
	public int getRcvAmount() {
		return rcvAmount;
	}
	
	@Override
	public void addRcvAmount(CurrencyEnum currencyEnum, int rcvAmount) {
		this.rcvAmount = this.rcvAmount+(rcvAmount * currencyEnum.getExchangeRate());
	}
*/
	
	@Override
	public List<Currency> getCurrencyList() {
		return currencyList;
	}
	
	@Override
	public boolean containsCurrency(int amount) {
		return currencyList.stream().filter(o -> o.getAmount() == amount).findFirst().isPresent();
	}

}
