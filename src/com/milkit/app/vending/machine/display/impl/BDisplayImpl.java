package com.milkit.app.vending.machine.display.impl;

import com.milkit.app.vending.machine.VandingMachine;
import com.milkit.app.vending.machine.currency.CurrencyEnum;
import com.milkit.app.vending.machine.currency.CurrencyFeeder;
import com.milkit.app.vending.machine.display.AbstractDisplayImpl;
import com.milkit.app.vending.machine.product.ProductManager;

public class BDisplayImpl extends AbstractDisplayImpl {

	@Override
	public String showMain(VandingMachine vandingMachine) throws Exception {
		StringBuilder builder = new StringBuilder();
		builder.append("###########################################################\n");
		builder.append("# Inputable currency.\n");
		builder.append("# You can only put the amount in the unit below.\n");
		builder.append("###########################################################\n");
		builder.append("# Coins : ").append(getCurrencyListStr(vandingMachine.getCoinFeeder())).append("\n");
		builder.append("# Bills : ").append(getCurrencyListStr(vandingMachine.getBillFeeder())).append("\n");
		builder.append("###########################################################\n");
		builder.append("# List of products for sale. Please choose between (").append(getProductListRangeStr(vandingMachine.getProductManager())).append(")\n");
		builder.append("###########################################################\n");
		builder.append(getProductListStr(vandingMachine.getProductManager(), vandingMachine.getCurrAmount()));
		builder.append("###########################################################\n");
		builder.append("# [How to use]\n");
		builder.append("###########################################################\n");
		builder.append("# To put in the amount, enter the amount in numbers as follows. (").append(getSimpleCurrencyListStr(vandingMachine)).append(")\n");
		builder.append("# To purchase a product, you can enter the following product code. (").append(getProductListRangeStr(vandingMachine.getProductManager())).append(")\n");
		builder.append("# Please press 'y' when the purchase is complete. (y)\n");
		builder.append("# Please press 'c' to cancel your purchase. (c)\n");
		builder.append("# Press 'x' to exit the program. (x)\n");
		builder.append("###########################################################\n");
		builder.append("# [Products purchased]	: ").append(getPurchaseProductStr(vandingMachine.getProductManager())).append("\n");
		builder.append("# [Remaining amount]	: ").append(CurrencyEnum.WON.getMark()).append(String.format("%,d", vandingMachine.getCurrAmount())).append("\n\n");
		builder.append("Please enter the value you want : ");
		
		return builder.toString();
	}



	@Override
	public String showCancel() {
		return "You canceled your purchase. Initialize input amount and purchase product.\n\n\n";
	}
	
	@Override
	public String showTerminate() {
		return "End the program. :-)\n\n";
	}


	@Override
	public String showInvalidCurrencyException() {
		return "This currency is not supported. Please put me on another line !!";
	}

	@Override
	public String showPutCurrency(int currency) {
		return CurrencyEnum.WON.getMark()+currency+" was put in !";
	}


	@Override
	protected String getPossibleBuyStr() {
		return "Available for purchase";
	}
	@Override
	protected String getOverdrawingStr() {
		return "Lack of balance";
	}

	@Override
	public String showInvalidProductException() {
		return "This product code is not for sale. Please enter another product code !!";
	}

	@Override
	public String showOverdrawingException() {
		return "There is not enough balance to purchase the product. Please put more money !!";
	}

	@Override
	public String showPutProduct(String productNM) {
		return productNM+" products purchased.";
	}

	@Override
	public String showComplete(ProductManager productManager, int currAmount) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("\n###########################################################\n");
		builder.append("# Thank you. You have completed your purchase !\n");
		builder.append("###########################################################\n");
		builder.append("# Products purchased : ").append(getPurchaseProductStr(productManager)).append("\n");
		builder.append("# Change amount		 : ").append(CurrencyEnum.WON.getMark()).append(String.format("%,d", currAmount)).append("\n");
		builder.append("###########################################################\n\n");

		return builder.toString();
	}


}
