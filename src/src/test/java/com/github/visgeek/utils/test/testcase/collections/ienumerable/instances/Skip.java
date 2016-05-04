package com.github.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Skip {
	@Test
	public void test_skip01() {
		IEnumerable<Integer> actual = Enumerable.of(1, 2, 3, 4).skip(2);
		Assert2.assertSequanceEquals(actual, 3, 4);
	}

	@Test
	public void test_skipWhile01_01() {
		IEnumerable<Integer> actual = Enumerable.of(1, 2, 3, 4, 3, 2, 1).skipWhile(n -> n <= 3);
		Assert2.assertSequanceEquals(actual, 4, 3, 2, 1);
	}

	@Test
	public void test_skipWhile02_01() {
		IEnumerable<Integer> actual = Enumerable.of(1, 2, 3, 4, 3, 2, 1).skipWhile((n, idx) -> n <= 3 && (idx + 1) % 3 != 0);
		Assert2.assertSequanceEquals(actual, 3, 4, 3, 2, 1);
	}
}
