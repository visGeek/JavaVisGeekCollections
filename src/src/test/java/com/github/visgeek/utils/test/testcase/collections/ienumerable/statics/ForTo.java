package com.github.visgeek.utils.test.testcase.collections.ienumerable.statics;

import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ForTo {
	@Test
	public void test__enumerable_forTo01_01() {
		List<Integer> actual = Enumerable.forTo(0, 3).toList();
		Assert2.assertSequanceEquals(actual, 0, 1, 2, 3);
	}

	@Test
	public void test__enumerable_forTo02_01() {
		IEnumerable<Object> actual = Enumerable.forTo(null, null, null).take(5);
		Assert2.assertSequanceEquals(actual, null, null, null, null, null);
	}

	@Test
	public void test__enumerable_forTo02_02() {
		IEnumerable<Integer> actual = Enumerable.forTo(() -> 1, null, null).take(5);
		Assert2.assertSequanceEquals(actual, 1, 1, 1, 1, 1);
	}

	@Test
	public void test__enumerable_forTo02_03() {
		IEnumerable<Integer> actual = Enumerable.forTo(() -> 1, null, n -> n + 1).take(5);
		Assert2.assertSequanceEquals(actual, 1, 2, 3, 4, 5);
	}

	@Test
	public void test__enumerable_forTo02_04() {
		IEnumerable<Integer> actual = Enumerable.forTo(() -> 1, n -> n <= 5, n -> n + 1);
		Assert2.assertSequanceEquals(actual, 1, 2, 3, 4, 5);
	}
}
