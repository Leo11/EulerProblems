package test.problems;

import junit.framework.Assert;

import org.junit.Test;

import problems.FourtyThree;

public class FourtyThreeTest {

	@Test
	public void test() {
		Assert.assertEquals(new Long("16695334890"), FourtyThree.fourtyThree());
	}

}
