package com.rausch.euler.problems;

import junit.framework.Assert;

import org.junit.Test;

import com.rausch.euler.problems.ThirtySeven;

public class ThirtySevenTest {

	@Test
	public void answer() {
		Assert.assertEquals(748317,
				ThirtySeven.findSumLeftRightTruncatablePrimes());
	}
}
