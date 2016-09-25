package com.srilola.samples.domain;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BuyOneGetOneOfferTest {
	
	private int quantity;
	
	private double price;
	
	private double discount;
	
	public  BuyOneGetOneOfferTest(int quantity, double price, double discount) {
		this.quantity = quantity;
		this.price  = price;
		this.discount = discount;
	}


	@Parameters(name = "{index}: testBuyOneGetOneOff({0},{1}) = {2}")
    public static Collection<Object[]> testBuyOneGetOneOffData() {
        return Arrays.asList(new Object[][]{
                {2, 0.5, 0.5},
                {3, 0.5, 0.5},
                {4, 0.5, 1.0},
                {5, 0.5, 1.0},
        });
    }

	@Test
	public void testBuyOneGetOneOff() {
		Assert.assertEquals(DiscountOffers.buyOneGetOneOff().apply(quantity, price), discount, 0.0000001);
	}

}
