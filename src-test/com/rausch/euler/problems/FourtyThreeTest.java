package com.rausch.euler.problems;

import junit.framework.Assert;

import org.junit.Test;

import com.rausch.euler.problems.fourtythree.FourtyThree;

public class FourtyThreeTest {

	@Test
	public void test() {
		Assert.assertEquals(new Long("16695334890"), FourtyThree.fourtyThree());
	}

}
