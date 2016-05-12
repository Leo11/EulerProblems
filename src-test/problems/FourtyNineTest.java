package problems;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import problems.FourtyNine;

public class FourtyNineTest {

	@Test
	public void answer() {

		String one = "148748178147";
		String two = "296962999629";

		List<String> list = FourtyNine.findArithmeticSequence();

		Assert.assertTrue(list.size() == 2);
		Assert.assertTrue(list.contains(one));
		Assert.assertTrue(list.contains(two));
	}

}
