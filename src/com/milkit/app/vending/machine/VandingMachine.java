package com.milkit.app.vending.machine;

import java.util.Properties;

import com.milkit.app.vending.exception.InvalidCurrencyException;
import com.milkit.app.vending.exception.SystemException;
import com.milkit.app.vending.machine.currency.*;
import com.milkit.app.vending.machine.currency.impl.*;
import com.milkit.app.vending.machine.display.*;
import com.milkit.app.vending.machine.display.impl.ADisplayImpl;
import com.milkit.app.vending.machine.display.impl.BDisplayImpl;
import com.milkit.app.vending.machine.product.Product;
import com.milkit.app.vending.machine.product.ProductManager;


public class VandingMachine {

    private final CurrencyFeeder coinFeeder;
	private final CurrencyFeeder billFeeder;
    private final Display display;

    private final ProductManager productManager;

	private int currAmount;

    
    public CurrencyFeeder getCoinFeeder() {
		return coinFeeder;
	}
	public CurrencyFeeder getBillFeeder() {
		return billFeeder;
	}
	public Display getDisplay() {
		return display;
	}
    public ProductManager getProductManager() {
		return productManager;
	}
    
    public int getCurrAmount() {
		return currAmount;
	}
    public void setCurrAmount(int currAmount) {
		this.currAmount = currAmount;
	}
    
    public void addCurrAmount(int currAmount) {
		this.currAmount = this.currAmount+currAmount;
	}

    public void removeCurrAmount(int purchaseAmount) {
		this.currAmount = this.currAmount-purchaseAmount;
	}

	public static VandingMachine build(Properties properties) throws SystemException {
    	String coin = properties.getProperty("coin", "A");
    	String bill = properties.getProperty("bill", "A");
    	String display = properties.getProperty("display", "A");
    	
    	VandingMachine vandingMachine = new VandingMachine
    			.Builder()
    		    .coinFeeder(coin)
    		    .billFeeder(bill)
    		    .display(display)
    		    .build();
    	
    	return vandingMachine;
    }
    
    public static class Builder {

    	private CurrencyFeeder coinFeeder;
        private CurrencyFeeder billFeeder;
        private Display display;
        
        public Builder() {
        }
        public Builder coinFeeder(String val) throws SystemException {
        	switch(val) {
				case "A":
					coinFeeder = new ACoinFeederImpl();
					break;
				case "B":
					coinFeeder = new BCoinFeederImpl();
					break;	
				case "C":
					coinFeeder = new CCoinFeederImpl();
					break;
				default:
					throw new SystemException("동전투입기 설정이 잘못되었습니다. 알맞는 유형의 동전투입기를 설정해 주세요. [현재설정:"+val+"]");
        	}
        	
            return this;
        }
        
        public Builder billFeeder(String val) throws SystemException {
        	switch(val) {
				case "A":
					billFeeder = new ABillFeederImpl();
					break;
				case "B":
					billFeeder = new BBillFeederImpl();
					break;	
				case "C":
					billFeeder = new CBillFeederImpl();
					break;
				default:
					throw new SystemException("지폐투입기 설정이 잘못되었습니다. 알맞는 유형의 지폐투입기를 설정해 주세요. [현재설정:"+val+"]");
        	}
        	
            return this;
        }
        
        public Builder display(String val) throws SystemException {
        	switch(val) {
				case "A":
					display = new ADisplayImpl();
					break;
				case "B":
					display = new BDisplayImpl();
					break;	
				default:
					throw new SystemException("디스플레이 설정이 잘못되었습니다. 알맞는 유형의 디스플레이를 설정해 주세요. [현재설정:"+val+"]");
        	}
        	
            return this;
        }
        
        public VandingMachine build() {
            return new VandingMachine(this);
        }
    }

    private VandingMachine(Builder builder) {
    	coinFeeder	= builder.coinFeeder;
    	billFeeder	= builder.billFeeder;
    	display		= builder.display;
    	
    	productManager = new ProductManager();
    	currAmount	= 0;
    }

    
	public String showMain() throws Exception {
		return display.showMain(this);
	}
	public String showCancel() {
		return display.showCancel();
	}
	
	public void cancel() {
		this.currAmount	= 0;
		
		productManager.cancel();
	}
	public String showTerminate() {
		return display.showTerminate();
	}
	
	public String putCurrency(int currency) throws Exception {
		if( coinFeeder.containsCurrency(currency) || billFeeder.containsCurrency(currency) ) {
			addCurrAmount(currency);
			
			return display.showPutCurrency(currency);
		} else {
			throw new InvalidCurrencyException( display.showInvalidCurrencyException() );
		}
	}
	
	public String purchaseProduct(String productCD) throws Exception {
		Product product = productManager.purchaseProduct(display, productCD, currAmount);
		
		removeCurrAmount(product.getPrice());
		
		return display.showPutProduct(product.getProductNM());
	}
	
	public String showComplete() {
		return display.showComplete(productManager, currAmount);
	}

	
	
}
