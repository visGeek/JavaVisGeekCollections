package com.github.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Take {
	@Test
	public void test_take01() {
		IEnumerable<Integer> actual = Enumerable.of(1, 2, 3, 4).take(2);
		Assert2.assertSequanceEquals(actual, 1, 2);
	}

	@Test
	public void test_takeWhile01_01() {
		IEnumerable<Integer> actual = Enumerable.of(1, 2, 3, 4, 3, 2, 1).takeWhile(n -> n <= 3);
		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void test_takeWhile02_01() {
		IEnumerable<Integer> actual = Enumerable.of(1, 2, 3, 4, 3, 2, 1).takeWhile((n, idx) -> n <= 3 && idx % 4 <= 3);
		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}
}
