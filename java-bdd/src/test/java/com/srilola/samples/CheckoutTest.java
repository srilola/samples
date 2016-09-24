package com.srilola.samples;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", strict=true)
public class CheckoutTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
