package test.problems;

import org.junit.Assert;
import org.junit.Test;

import problems.ThirtySix;

public class ThirtySixTest {

	@Test
	public void answer() {
		Assert.assertEquals(872187, ThirtySix.findPalindromicDualBase(1000000));
	}

}
