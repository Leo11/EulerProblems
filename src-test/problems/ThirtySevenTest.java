package problems;

import junit.framework.Assert;

import org.junit.Test;

import problems.ThirtySeven;

public class ThirtySevenTest {

	@Test
	public void answer() {
		Assert.assertEquals(748317,
				ThirtySeven.findSumLeftRightTruncatablePrimes());
	}
}
