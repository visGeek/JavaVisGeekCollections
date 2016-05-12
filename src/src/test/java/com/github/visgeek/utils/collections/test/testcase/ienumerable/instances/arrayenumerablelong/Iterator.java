package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.arrayenumerablelong;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Iterator {
	@Test
	public void test() {
		IEnumerable<Long> source = Enumerable.of(1L, 2L, 3L);
		Assert2.assertSequanceEquals(source, 1L, 2L, 3L);
	}
}
