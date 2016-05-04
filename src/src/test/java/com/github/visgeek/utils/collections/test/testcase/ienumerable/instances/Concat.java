package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Concat {
	@Test
	public void test_concat01_01() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3);
		IEnumerable<Integer> values2 = Enumerable.of(4, 5, 6);

		IEnumerable<Integer> actual = values1.concat(values2);

		Assert2.assertSequanceEquals(actual, 1, 2, 3, 4, 5, 6);
	}

	@Test
	public void test_concat01_02() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3);
		IEnumerable<Integer> values2 = Enumerable.of(4, 5, 6);
		IEnumerable<Integer> values3 = Enumerable.of(7, 8, 9);

		IEnumerable<Integer> actual = values1.concat(values2).concat(values3);

		Assert2.assertSequanceEquals(actual, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	@Test
	public void test_concat02_01() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3);
		IEnumerable<Integer> actual = values1.concat(4, 5, 6);
		Assert2.assertSequanceEquals(actual, 1, 2, 3, 4, 5, 6);
	}
}
