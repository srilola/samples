package com.srilola.samples.features;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.srilola.samples.ShoppingCart;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckoutSteps {
	
	private Map<String, Double> priceList;
	private List<String> itemList;
	private ShoppingCart cart = null;
	
	@Given("^the shop sells the following items:$")
	public void the_shop_sells_the_following_items(Map<String, Double> priceList) throws Throwable {
	    this.priceList = priceList;
	}

	@Given("^a customer shopping cart contains:$")
	public void a_customer_shopping_cart_contains(List<String> itemList) throws Throwable {
		this.itemList = itemList;
	}

	@When("^the shopping cart is scanned at the till$")
	public void the_shopping_cart_is_scanned_at_the_till() throws Throwable {
		cart = new ShoppingCart(priceList);
		for (String item : itemList) {
			cart.addItem(item);
		}
		
	}

	@Then("^checkout system should output total cost as £(\\d+)\\.(\\d+)$")
	public void checkout_system_should_output_total_cost_as_£(int pounds, int pence) throws Throwable {
		Assert.assertTrue(cart.getTotalCost().equals((pounds * 100 + pence)/100.0));
	}


}
