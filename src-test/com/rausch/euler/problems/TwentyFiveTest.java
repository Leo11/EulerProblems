package com.rausch.euler.problems;

import org.junit.Assert;
import org.junit.Test;

import com.rausch.euler.problems.TwentyFive;

public class TwentyFiveTest {

	@Test
	public void answer() {
		Assert.assertEquals(4782, TwentyFive.findFirstFibWithNDigits(1000));
	}

}
