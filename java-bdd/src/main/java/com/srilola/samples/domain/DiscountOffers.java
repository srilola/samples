package com.srilola.samples.domain;


public class DiscountOffers {
	
	public static final String  THREE_FOR_TWO = "3 for price of 2";
	
	public static final String BOGOF = "Buy one, get one free";
	
	@FunctionalInterface
	interface Offer<Q, P, D> {
			public D apply(Q q, P p);
	}
	
	static Offer<Integer, Double, Double> getOffer(String offerName) {
		if (THREE_FOR_TWO.equals(offerName))
			return threeForTwo();
		
		if (BOGOF.equals(offerName)) 
			return buyOneGetOneOff();
			
		return noop();
	}
	
	static Offer<Integer, Double, Double> buyOneGetOneOff() {
		return (qty, price) -> (qty /2) * price;
	}

	static Offer<Integer, Double, Double> threeForTwo() {
		return (qty, price) -> (qty /3) * price;
	}

	static Offer<Integer, Double, Double> noop() {
		return (qty, price) -> 0.0;
	}
	
	public static double getDiscount(int qty, double price, String offer) {
		return getOffer(offer).apply(qty, price);
	}
}
