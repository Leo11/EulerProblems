package test.problems;

import org.junit.Assert;
import org.junit.Test;

import resources.Utilities;

import problems.Twenty;

public class TwentyTest {

	@Test
	public void answer() {

		int summation = (int) Utilities.getSummationOfMap(Twenty
				.solveFactorials(100));

		Assert.assertEquals(648, summation);
	}

}
