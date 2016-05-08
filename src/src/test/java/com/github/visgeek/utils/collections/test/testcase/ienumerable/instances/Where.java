package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Where {
	@Test
	public void test01_01() {
		IEnumerable<Integer> actual = Enumerable.of(1, 2, 3).where(n -> 2 <= n);
		Assert2.assertSequanceEquals(actual, 2, 3);
	}

	@Test
	public void test02_01() {
		IEnumerable<Integer> actual = Enumerable.of(0, 2, 2, 3).where((n, idx) -> n <= idx);
		Assert2.assertSequanceEquals(actual, 0, 2, 3);
	}
}
