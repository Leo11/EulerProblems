package com.rausch.euler.problems;

import junit.framework.Assert;

import org.junit.Test;

import com.rausch.euler.problems.Thirty;

public class ThirtyTest {

	@Test
	public void answer() {
		Assert.assertEquals(443839, Thirty.sumOfSumOfFifthPowers());
	}

}
