package resources;

import org.junit.Assert;
import org.junit.Test;

import resources.Utilities;

public class UtilitiesTest {

	@Test
	public void testPalindrome() {
		Assert.assertTrue(Utilities.isPalindrome("0"));
	}

	@Test
	public void testPalindrome1() {
		Assert.assertTrue(Utilities.isPalindrome("1"));
	}

	@Test
	public void testPalindrome2() {
		Assert.assertTrue(Utilities.isPalindrome("11"));
	}

	@Test
	public void testPalindrome3() {
		Assert.assertTrue(Utilities.isPalindrome("101"));
	}

	@Test
	public void testPalindrome4() {
		Assert.assertTrue(Utilities.isPalindrome("1001"));
	}

	@Test
	public void testPalindrome5() {
		Assert.assertFalse(Utilities.isPalindrome("10"));
	}

	@Test
	public void testPalindrome6() {
		Assert.assertFalse(Utilities.isPalindrome("100"));
	}

	@Test
	public void testPalindrome7() {
		Assert.assertFalse(Utilities.isPalindrome(""));
	}

	@Test
	public void testPalindrome8() {
		Assert.assertTrue(Utilities.isPalindrome("racecar"));
	}
}
