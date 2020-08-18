package com.milkit.app.vending.machine.display;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import com.milkit.app.util.StringUtil;
import com.milkit.app.vending.exception.SystemException;
import com.milkit.app.vending.machine.VandingMachine;
import com.milkit.app.vending.machine.currency.Currency;
import com.milkit.app.vending.machine.currency.CurrencyEnum;
import com.milkit.app.vending.machine.currency.CurrencyFeeder;
import com.milkit.app.vending.machine.product.Product;
import com.milkit.app.vending.machine.product.ProductManager;

public abstract class AbstractDisplayImpl implements Display {
	
	protected String getCurrencyListStr(CurrencyFeeder currencyFeeder) {
		List<Currency> list = currencyFeeder.getCurrencyList();
		
		StringBuilder builder = new StringBuilder();
		for(Currency currency : list) {
			builder.append(currency.toString()).append("\t");
		}
		
		return builder.toString();
	}
	
	protected String getSimpleCurrencyListStr(VandingMachine vandingMachine) {
		List<Currency> coinList = vandingMachine.getCoinFeeder().getCurrencyList();
		List<Currency> billList = vandingMachine.getBillFeeder().getCurrencyList();
		
		StringBuilder builder = new StringBuilder();
		for(Currency currency : coinList) {
			builder.append(currency.getAmount()).append(", ");
		}
		for(Currency currency : billList) {
			builder.append(currency.getAmount()).append(", ");
		}
		
		if((coinList.size() + billList.size()) > 0) {
			builder.delete(builder.length()-2, builder.length());
		}
		
		return builder.toString();
	}

	
	protected String getProductListRangeStr(ProductManager productManager) {
		List<Product> list = productManager.getProductList();
		
		StringBuilder builder = new StringBuilder();
		if(list != null && list.size() > 0) {
			builder.append(list.get(0).getProductCD()).append(" ~ ").append(list.get(list.size()-1).getProductCD());
		}
		
		return builder.toString();
	}
	
	protected String getProductListStr(ProductManager productManager, int currAmount) throws Exception {
		List<Product> list = productManager.getProductList();
		
		StringBuilder builder = new StringBuilder();
		for(Product product : list) {
			builder.append("# ").append( StringUtil.convertFixedStr(product.toString(), Charset.forName("UTF-8"), 30) ).append("\t").append(getCanBuyStr(product, currAmount)).append("\n");
		}
		
		return builder.toString();
	}
	
	protected String getCanBuyStr(Product product, int currAmount) {
		String canBuyStr = getPossibleBuyStr();
		
		if(product.getPrice() > currAmount) {
			canBuyStr = getOverdrawingStr();
		}
		
		return canBuyStr;
	}

	protected String getPurchaseProductStr(ProductManager productManager) {
		Map<String, Integer> purchaseMap = productManager.getPurchaseMap();
		
		StringBuilder builder = new StringBuilder();
		for( Map.Entry<String, Integer> elem : purchaseMap.entrySet() ) {
			Product product = productManager.getProduct(elem.getKey());
			builder.append(product.getProductNM()).append(" X ").append(elem.getValue()).append(", ");
		}
		
		if(purchaseMap.size() > 0) {
			builder.delete(builder.length()-2, builder.length());
		}
		
		return builder.toString();
	}

	
	protected abstract String getPossibleBuyStr();
	
	protected abstract String getOverdrawingStr();

}
