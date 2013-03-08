package test.resources;

import static org.junit.Assert.*;

import org.junit.Test;

import resources.Permutation;

public class PermutationTest {

	@Test
	public void test() {
		Permutation permutation = new Permutation();
		permutation.permute("Leo");
		assertTrue(permutation.results.size() == 6);
		assertTrue(permutation.results.contains("Leo"));
		assertTrue(permutation.results.contains("eLo"));
		assertTrue(permutation.results.contains("eoL"));
		assertTrue(permutation.results.contains("Loe"));
		assertTrue(permutation.results.contains("oLe"));
		assertTrue(permutation.results.contains("oeL"));
	}
}
