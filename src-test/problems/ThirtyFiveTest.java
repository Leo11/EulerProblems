package problems;

import junit.framework.Assert;

import org.junit.Test;

import problems.ThirtyFive;

public class ThirtyFiveTest {

	@Test
	public void answer() {
		Assert.assertEquals(55, ThirtyFive.countCirculerPrimesBelowN(1000000));
	}

}
