package com.rausch.euler.problems;

import junit.framework.Assert;

import org.junit.Test;

import com.rausch.euler.problems.ThirtyTwo;
import com.rausch.euler.resources.Utilities;

public class ThirtyTwoTest {

	@Test
	public void answer() {
		Assert.assertEquals(45228,
				Utilities.getSummationOfSet(ThirtyTwo.sumOfProblemThirtyTwo()));
	}
}
