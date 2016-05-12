package com.rausch.euler.problems;

import junit.framework.Assert;

import org.junit.Test;

import com.rausch.euler.problems.twentyone.TwentyOne;

public class TwentyOneTest {

	@Test
	public void answer() {
		int limit = 10000;
		Assert.assertEquals(31626, TwentyOne.sumOfAmicableNumbers(limit));
	}

}
