package com.store;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilityTest {
	
	private Utility utility;

	
	@SuppressWarnings("static-access")
	@Test
	public void whenValidStringIsPassedThenNumberOrNotShouldReturnTrue() {
		assertTrue(utility.numberOrNot("12"));
		assertTrue(utility.numberOrNot("0"));
		assertTrue(utility.numberOrNot("-34"));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void whenNotValidStringIsPassedThenNumberOrNotShouldReturnFalse() {
		assertFalse(utility.numberOrNot("12.5"));
		assertFalse(utility.numberOrNot("34,67"));
		assertFalse(utility.numberOrNot("af"));
	}
}
