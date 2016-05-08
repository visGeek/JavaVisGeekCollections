package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ToList {
	@Test
	public void test01() {
		List<Integer> actual = Enumerable.of(1, 2, 3).toList();
		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}
}
