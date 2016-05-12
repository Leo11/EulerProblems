package problems;

import junit.framework.Assert;

import org.junit.Test;

import problems.TwentyOne;

public class TwentyOneTest {

	@Test
	public void answer() {
		int limit = 10000;
		Assert.assertEquals(31626, TwentyOne.sumOfAmicableNumbers(limit));
	}

}
