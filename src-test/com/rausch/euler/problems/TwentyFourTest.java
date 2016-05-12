package com.rausch.euler.problems;

import org.junit.Assert;
import org.junit.Test;

import com.rausch.euler.problems.twentyfour.TwentyFour;

public class TwentyFourTest {

	@Test
	public void answer() {
		Assert.assertEquals("2783915460", TwentyFour
				.findNthLexicographicPermutation("0123456789", 1000000));
	}

}
