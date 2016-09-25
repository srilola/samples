package com.srilola.samples.domain;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NoDiscountTest {
	
	private int quantity;
	
	private double price;
	
	private double discount;
	
	public  NoDiscountTest(int quantity, double price, double discount) {
		this.quantity = quantity;
		this.price  = price;
		this.discount = discount;
	}

	@Parameters(name = "{index}: testNoop({0},{1}) = {2}")
    public static Collection<Object[]> testNoopData() {
        return Arrays.asList(new Object[][]{
                {2, 0.5, 0.0},
                {3, 0.5, 0.0},
                {4, 0.5, 0.0},
                {5, 0.5, 0.0},
                {6, 0.5, 0.0},
                {7, 0.5, 0.0},
                {9, 0.5, 0.0},
                {11, 0.5, 0.0},
        });
    }

	@Test
	public void testNoop() {
		Assert.assertEquals(DiscountOffers.noop().apply(quantity, price), discount, 0.0000001);
	}

}
