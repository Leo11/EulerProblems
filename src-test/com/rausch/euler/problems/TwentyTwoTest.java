package com.rausch.euler.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import junit.framework.Assert;

import org.junit.Test;

import com.rausch.euler.problems.twentytwo.TwentyTwo;

public class TwentyTwoTest {

	@Test
	public void answer() {
		String path = "src/Problem22_names.txt";

		List<String> names = TwentyTwo.loadList(path);
		names = TwentyTwo.stripQuotes(names);

		Set<String> orderedNames = new TreeSet<String>(names);

		Map<Integer, String> mapWithIndexes = new HashMap<Integer, String>();

		int count = 1;
		for (String s : orderedNames) {
			mapWithIndexes.put(count, s);
			count++;
		}

		Assert.assertEquals(871198282, TwentyTwo.addNameValues(mapWithIndexes));
	}

}
