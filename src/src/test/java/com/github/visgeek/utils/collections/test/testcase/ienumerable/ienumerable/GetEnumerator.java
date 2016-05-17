package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.util.Arrays;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.Enumerator;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class GetEnumerator {
	@Test
	public void enumerator() {
		IEnumerable<Integer> source = () -> Enumerable.range(0, 3).iterator();
		Integer[] expected = new Integer[] { 0, 1, 2 };

		Enumerator<Integer> e = source.getEnumerator();
		IEnumerable<Integer> actual = () -> e;
		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void iterator() {
		IEnumerable<Integer> source = () -> Arrays.asList(0, 1, 2).iterator();
		Integer[] expected = new Integer[] { 0, 1, 2 };

		Enumerator<Integer> e = source.getEnumerator();
		IEnumerable<Integer> actual = () -> e;
		Assert2.assertSequanceEquals(actual, expected);
	}
}
