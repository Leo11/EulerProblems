package com.rausch.euler.problems;

import junit.framework.Assert;

import org.junit.Test;

import com.rausch.euler.problems.thirtyseven.ThirtySeven;

public class ThirtySevenTest {

	@Test
	public void answer() {
		Assert.assertEquals(748317,
				ThirtySeven.findSumLeftRightTruncatablePrimes());
	}
}
