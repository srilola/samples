package com.srilola.samples.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {

	private ShoppingCart classUnderTest;
	
	@Test
	public void testAddItem() {
		// given
		List<Product> productList = Arrays.asList(new Product("Apple", 123.0, null), 
												  new Product("Orange", 123.0, null));
		classUnderTest = new ShoppingCart(productList);		
		// when
		classUnderTest.addItem("Orange");
		classUnderTest.addItem("Orange");
		classUnderTest.addItem("Apple");
		// then
		Assert.assertTrue(classUnderTest.getItems().size() == 2);
		Assert.assertTrue(classUnderTest.getItems().get("Orange") == 2);
		Assert.assertTrue(classUnderTest.getItems().get("Apple") == 1);
	}

	@Test
	public void testAddItemWithQuantity() {
		// given
		List<Product> productList = Arrays.asList(new Product("Apple", 123.0, null),
												  new Product("Orange", 123.0, null));
		classUnderTest = new ShoppingCart(productList);		
		// when
		classUnderTest.addItem("Orange", 2);
		classUnderTest.addItem("Apple", 3);
		// then
		Assert.assertTrue(classUnderTest.getItems().size() == 2);
		Assert.assertTrue(classUnderTest.getItems().get("Orange") == 2);
		Assert.assertTrue(classUnderTest.getItems().get("Apple") == 3);
	}
	
}
