package com.github.visgeek.utils.collections.test.testcase.readonlycollectionbase;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class AsStream {
	@Test
	public void test() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		Integer[] expected = source;

		IEnumerable<Integer> enumerable = Enumerable.of(source);
		IEnumerable<Integer> actual = () -> enumerable.asStream().iterator();
		Assert2.assertSequanceEquals(actual, expected);
	}
}
