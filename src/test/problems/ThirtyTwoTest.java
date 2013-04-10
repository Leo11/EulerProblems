package test.problems;

import junit.framework.Assert;

import org.junit.Test;

import problems.ThirtyTwo;

import resources.Utilities;

public class ThirtyTwoTest {

	@Test
	public void answer() {
		Assert.assertEquals(45228,
				Utilities.getSummationOfSet(ThirtyTwo.sumOfProblemThirtyTwo()));
	}
}
