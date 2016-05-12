package problems;

import org.junit.Assert;
import org.junit.Test;
import problems.TwentyFour;

public class TwentyFourTest {

	@Test
	public void answer() {
		Assert.assertEquals("2783915460", TwentyFour
				.findNthLexicographicPermutation("0123456789", 1000000));
	}

}
