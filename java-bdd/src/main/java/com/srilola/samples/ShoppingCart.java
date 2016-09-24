package com.srilola.samples;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

	private final Map<String, Integer> itemList;
	private final Map<String, Double> priceList;

	public ShoppingCart(Map<String, Double> priceList) {
		this.itemList = new HashMap<String, Integer>();
		this.priceList = priceList;
	}

	public void addItem(String item) {
		addItem(item, 1);
	}

	public void addItem(String item, Integer quantity) {
		Integer currQuantity = this.itemList.get(item);
		this.itemList.put(item, currQuantity != null ? currQuantity+quantity : quantity);
	}

	public Double getTotalCost() {
		return itemList.entrySet().stream().mapToDouble(e -> e.getValue() * priceList.get(e.getKey())).sum();
	}
	
	// visible only for testing
	Map<String, Integer> getItems() {
		return itemList;
	}

}
