package com.srilola.samples;

import static org.mockito.Mockito.*;


import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ShoppingCartTest {

	private ShoppingCart testShoppingCart;
	
	Map<String, Double> priceList = Mockito.mock(Map.class); 
	
	@Before
	public void setup() {
		testShoppingCart = new ShoppingCart(priceList);
	}
	@Test
	public void testAddItem() {
		testShoppingCart.addItem("Orange");
		testShoppingCart.addItem("Orange");
		testShoppingCart.addItem("Apple");
		Assert.assertTrue(testShoppingCart.getItems().size() == 2);
		Assert.assertTrue(testShoppingCart.getItems().get("Orange") == 2);
		Assert.assertTrue(testShoppingCart.getItems().get("Apple") == 1);
	}

	@Test
	public void testAddItemWithQuantity() {
		testShoppingCart.addItem("Orange", 2);
		testShoppingCart.addItem("Apple", 3);
		Assert.assertTrue(testShoppingCart.getItems().size() == 2);
		Assert.assertTrue(testShoppingCart.getItems().get("Orange") == 2);
		Assert.assertTrue(testShoppingCart.getItems().get("Apple") == 3);
	}

	@Test
	public void testGetTotalCost() {
		when(priceList.get("Orange")).thenReturn(0.2);
		when(priceList.get("Apple")).thenReturn(0.1);
		testShoppingCart.addItem("Orange", 2);
		testShoppingCart.addItem("Apple", 3);
		Assert.assertEquals(testShoppingCart.getTotalCost(), 0.7, 0.0000001);
		verify(priceList,times(1)).get("Orange");
		verify(priceList, times(1)).get("Apple");
	}
	
}
