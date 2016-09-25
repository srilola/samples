package com.srilola.samples.domain;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DiscountOffersTest {
	
	private int quantity;
	
	private double price;
	
	private String offer;
	
	private double discount;
	
	public  DiscountOffersTest(int quantity, double price, String offer, double discount) {
		this.quantity = quantity;
		this.price  = price;
		this.offer = offer;
		this.discount = discount;
	}

	@Test
	public void testGetOffer() {
		Assert.assertTrue(DiscountOffers.getOffer("3 for price of 2") instanceof DiscountOffers.Offer);
		Assert.assertTrue(DiscountOffers.getOffer("Buy one, get one free") instanceof DiscountOffers.Offer);
	}

	@Parameters(name = "{index}: getDiscount({0},{1}, {2}) = {3}")
    public static Collection<Object[]> testDistcountData() {
        return Arrays.asList(new Object[][]{
        		{1, 0.5, DiscountOffers.BOGOF, 0.0},
                {2, 0.5, DiscountOffers.BOGOF, 0.5},
                {3, 0.5, DiscountOffers.BOGOF, 0.5},
                {4, 0.5, DiscountOffers.BOGOF, 1.0},
                {2, 0.5, DiscountOffers.THREE_FOR_TWO, 0.0},
                {3, 0.5, DiscountOffers.THREE_FOR_TWO, 0.5},
                {4, 0.5, DiscountOffers.THREE_FOR_TWO, 0.5},
                {5, 0.5, DiscountOffers.THREE_FOR_TWO, 0.5},
                {6, 0.5, DiscountOffers.THREE_FOR_TWO, 1.0},
                {6, 0.5, null, 0.0}
                
        });
    }

	@Test
	public void getDiscount() {
		Assert.assertEquals(DiscountOffers.getDiscount(quantity, price, offer), discount, 0.00001);
	}
}
