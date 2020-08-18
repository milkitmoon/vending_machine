package com.milkit.app.vending.machine.display;

import com.milkit.app.vending.machine.VandingMachine;
import com.milkit.app.vending.machine.currency.CurrencyFeeder;
import com.milkit.app.vending.machine.product.ProductManager;

public interface Display {

	public String showMain(VandingMachine vandingMachine) throws Exception;

	public String showCancel();

	public String showTerminate();
	
	public String showInvalidCurrencyException();

	public String showPutCurrency(int currency);

	public String showInvalidProductException();

	public String showOverdrawingException();

	public String showPutProduct(String productNM);

	public String showComplete(ProductManager productManager, int currAmount);

}
