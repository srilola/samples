package com.srilola.samples.domain;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({DiscountOffers.class})
public class ProductTest {

	private Product classUnderTest;
	
	@Before
	public void setup() {
		// given
		PowerMockito.mockStatic(DiscountOffers.class);
	}
	@Test
	public void testGetName() {
		// given
		classUnderTest = new Product("ABC", 123.0, "ExcellentOffer");
		// when
		String name = classUnderTest.getName();
		// then
		Assert.assertEquals(name, "ABC");
	}

	@Test
	public void testGetPrice() {
		// given
		classUnderTest = new Product("ABC", 123.0, "ExcellentOffer");
		// when
		Double price = classUnderTest.getPrice();
		// then		
		Assert.assertEquals(price, 123.0, 0.0);
	}

	@Test
	public void testGetOffer() {
		// given
		classUnderTest = new Product("ABC", 123.0, "ExcellentOffer");
		// when
		String offerName = classUnderTest.getOffer();
		// then
		Assert.assertEquals(offerName, "ExcellentOffer");
	}

	@Test
	public void testGetDiscount() {
		// Given
		classUnderTest = new Product("ABC", 123.0, "ExcellentOffer");
		// when
		when(DiscountOffers.getDiscount(1, 123.0, "ExcellentOffer")).thenReturn(0.0);
		double discount = classUnderTest.getDiscount(1);
		// then
		PowerMockito.verifyStatic(times(1));
		DiscountOffers.getDiscount(1, 123.0, "ExcellentOffer");
		Assert.assertEquals(discount, 0.0, 0.0);
	}

}
