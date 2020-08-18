package com.milkit.app.vending.machine.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.milkit.app.vending.exception.InvalidProductException;
import com.milkit.app.vending.exception.OverdrawingException;
import com.milkit.app.vending.machine.display.Display;


public class ProductManager {

	private List<Product> productList;
	
	private Map<String, Integer> purchaseMap;
	
	public ProductManager() {
		init();
	}
	
	private void init() {
		productList = new ArrayList<Product>();
		productList.add(new Product("p1", "캔음료", 1000));
		productList.add(new Product("p2", "커피", 1000));
		productList.add(new Product("p3", "영화표", 10000));
		productList.add(new Product("p4", "승차권", 1500));
		productList.add(new Product("p5", "승선권", 5000));
		productList.add(new Product("p6", "항공권", 50000));
		productList.add(new Product("p7", "담배", 5000));
		productList.add(new Product("p8", "껌", 100));
		productList.add(new Product("p9", "신문", 100));
		productList.add(new Product("p10", "잡지", 5000));
		productList.add(new Product("p11", "책", 10000));
		
		purchaseMap = new HashMap<String, Integer>();
	}
	
	public List<Product> getProductList() {
		return productList;
	}

	public Map<String, Integer> getPurchaseMap() {
		return purchaseMap;
	}

	public boolean containsProduct(String productCD) {
		return productList.stream().filter(o -> o.getProductCD().equals(productCD)).findFirst().isPresent();
	}

	public Product getProduct(String productCD) {
		return productList.stream().filter(o -> o.getProductCD().equals(productCD)).findAny().orElse(null);
	}
	
	public Product purchaseProduct(Display display, String productCD, int currAmount) throws Exception {
		Product product = getProduct(productCD);
		
		if( product != null ) {
			if(product.getPrice() <= currAmount) {
				purchaseProduct(productCD);
				
				return product;
			} else {
				throw new OverdrawingException( display.showOverdrawingException() );
			}

		} else {
			throw new InvalidProductException( display.showInvalidProductException() );
		}
	}

	public void cancel() {
		purchaseMap = new HashMap<String, Integer>();
	}
	

	private void purchaseProduct(String productCD) {
		if( purchaseMap.containsKey(productCD) ) {
			purchaseMap.put(productCD, purchaseMap.get(productCD)+1);
		} else {
			purchaseMap.put(productCD, 1);
		}
	}

}
