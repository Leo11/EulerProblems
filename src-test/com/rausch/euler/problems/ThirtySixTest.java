package com.rausch.euler.problems;

import org.junit.Assert;
import org.junit.Test;

import com.rausch.euler.problems.thirtysix.ThirtySix;

public class ThirtySixTest {

	@Test
	public void answer() {
		Assert.assertEquals(872187, ThirtySix.findPalindromicDualBase(1000000));
	}

}
