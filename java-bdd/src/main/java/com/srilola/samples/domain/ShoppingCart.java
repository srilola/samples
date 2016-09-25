package com.srilola.samples.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ShoppingCart {

	private final Map<Product, Integer> items;
	private final List<Product> productList;

	public ShoppingCart(final List<Product> productList) {
		this.productList = productList;
		this.items = new HashMap<Product, Integer>();
	}

	public void addItem(String prod, Integer quantity) {
		Product p = findProduct(prod);
		Integer currQuantity = this.items.get(p);
		this.items.put(p, currQuantity != null ? currQuantity+quantity : quantity);
	}
	
	public void addItem(String productName) {
		addItem(productName, 1);
	}

	public Double getTotalCost() {
		return items.entrySet().stream().mapToDouble(e -> calculateCost(e.getKey(), e.getValue())).sum();
	}
	
	// visible only for testing
	Map<String, Integer> getItems() {
		return items.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().getName(), e -> e.getValue()));
	}
	
	private Double calculateCost(Product p, Integer quantity) {
		return p.getPrice() * quantity - p.getDiscount(quantity);
	}
	
	private Product findProduct(String prod) {
		try {
			return productList.stream().filter(p -> p.getName().equals(prod)).findFirst().get();
		} catch(NoSuchElementException nse) {
			return null;
		}
	}

}
