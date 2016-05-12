package com.rausch.euler.problems;

import org.junit.Assert;
import org.junit.Test;

import com.rausch.euler.problems.Twenty;

public class TwentyTest {

	@Test
	public void answer() {

		int summation = (int) Twenty.solveFactorials(100).summationOfDigits();

		Assert.assertEquals(648, summation);
	}

}
