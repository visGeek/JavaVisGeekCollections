package com.github.visgeek.utils.collections.test.testcase.ienumerable.statics;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ForTo03 {
	@Test
	public void test01() {
		IEnumerable<Object> actual = Enumerable.forTo(null, null, null).take(5);
		Assert2.assertSequanceEquals(actual, null, null, null, null, null);
	}

	@Test
	public void test02() {
		IEnumerable<Integer> actual = Enumerable.forTo(() -> 1, null, null).take(5);
		Assert2.assertSequanceEquals(actual, 1, 1, 1, 1, 1);
	}

	@Test
	public void test03() {
		IEnumerable<Integer> actual = Enumerable.forTo(() -> 1, null, n -> n + 1).take(5);
		Assert2.assertSequanceEquals(actual, 1, 2, 3, 4, 5);
	}

	@Test
	public void test04() {
		IEnumerable<Integer> actual = Enumerable.forTo(() -> 1, n -> n <= 5, n -> n + 1);
		Assert2.assertSequanceEquals(actual, 1, 2, 3, 4, 5);
	}
}
