package problems;

import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

import problems.TwentyNine;

import resources.ArbitraryNum;

public class TwentyNineTest {

	@Test
	public void test() {
		Set<ArbitraryNum> result = TwentyNine.distinctPowers(100, 100);
		Assert.assertEquals(9801, result.size());	
	}
}
