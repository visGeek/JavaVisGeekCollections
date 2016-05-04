package com.github.visgeek.utils.collections.test.testcase.ienumerable.statics;

import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Range {
	@Test
	public void test__enumerable_range01() {
		List<Integer> actual = Enumerable.range(0, 3).toList();
		Assert2.assertSequanceEquals(actual, 0, 1, 2);
	}

	@Test
	public void test__enumerable_range02() {
		List<Integer> actual = Enumerable.range(2, 3).toList();
		Assert2.assertSequanceEquals(actual, 2, 3, 4);
	}

	@Test
	public void test__enumerable_range03() {
		List<Integer> actual = Enumerable.range(-1, 3).toList();
		Assert2.assertSequanceEquals(actual, -1, 0, 1);
	}
}
