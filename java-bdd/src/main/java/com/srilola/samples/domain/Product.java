package com.srilola.samples.domain;

public class Product {

	private final String name;
	private Double price;
	private String offer;
	
	public Product(String name, Double price,  String offer) {
		this.name = name;
		this.price = price;
		this.offer = offer;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}
	
	public String getOffer() {
		return offer;		
	}
	
	public Double getDiscount(Integer quantity){
		return DiscountOffers.getDiscount(quantity, price, offer);
	}

}
