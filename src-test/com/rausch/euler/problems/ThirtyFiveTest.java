package com.rausch.euler.problems;

import junit.framework.Assert;

import org.junit.Test;

import com.rausch.euler.problems.thirtyfive.ThirtyFive;

public class ThirtyFiveTest {

	@Test
	public void answer() {
		Assert.assertEquals(55, ThirtyFive.countCirculerPrimesBelowN(1000000));
	}

}
