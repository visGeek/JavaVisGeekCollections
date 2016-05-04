package com.github.visgeek.utils.test.testcase.collections.ienumerable.statics;

import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Repeat {
	@Test
	public void test__enumerable_repeat01() {
		List<Integer> actual = Enumerable.repeat(1, 3).toList();
		Assert2.assertSequanceEquals(actual, 1, 1, 1);
	}
}
