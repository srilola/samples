package com.srilola.samples.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.Assert;

import com.srilola.samples.domain.Product;
import com.srilola.samples.domain.ShoppingCart;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckoutSteps {
	
	private List<Product> productCatalog;
	private List<String> items;
	private ShoppingCart cart = null;
	
	@Given("^the shop sells the following items:$")
	public void the_shop_sells_the_following_items(List<Product> productCatalog) throws Throwable {
	    this.productCatalog = productCatalog;
	}

	@Given("^a customer shopping cart contains:$")
	public void a_customer_shopping_cart_contains(List<String> items) throws Throwable {
		this.items = items;
	}

	@Given("^a customer shopping cart contains \\(with quantity\\):$")
	public void a_customer_shopping_cart_contains_with_quantity(Map<String, Integer> items) throws Throwable {
		this.items = new ArrayList<String>();
		for (Map.Entry<String, Integer> e : items.entrySet()){
			for( int i =0; i < e.getValue(); i++) {
				this.items.add(e.getKey());
			}
		}
	}

	@When("^the shopping cart is scanned at the till$")
	public void the_shopping_cart_is_scanned_at_the_till() throws Throwable {
		cart = new ShoppingCart(productCatalog);
		items.forEach(e -> cart.addItem(e));	
	}

	@Then("^checkout system should output total cost as £(\\d+)\\.(\\d+)$")
	public void checkout_system_should_output_total_cost_as_£(int pounds, int pence) throws Throwable {
		Assert.assertEquals(cart.getTotalCost(), pounds + pence / 100.0 , 00000000000001);
	}


}
