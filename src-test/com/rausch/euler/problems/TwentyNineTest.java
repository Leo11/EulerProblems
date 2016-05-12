package com.rausch.euler.problems;

import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

import com.rausch.euler.problems.TwentyNine;
import com.rausch.euler.resources.ArbitraryNum;

public class TwentyNineTest {

	@Test
	public void test() {
		Set<ArbitraryNum> result = TwentyNine.distinctPowers(100, 100);
		Assert.assertEquals(9801, result.size());	
	}
}
