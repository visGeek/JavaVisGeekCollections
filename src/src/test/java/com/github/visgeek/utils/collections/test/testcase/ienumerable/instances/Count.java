package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Count {
	@Test
	public void test01_01() {
		IEnumerable<Integer> values = Enumerable.of(1, 2, 3);
		int actual = values.count();
		Assert.assertEquals(actual, 3);
	}

	@Test
	public void test01_02() {
		IEnumerable<Integer> values = Enumerable.range(0, 3);
		int actual = values.count();
		Assert.assertEquals(actual, 3);
	}

	@Test
	public void test02_01() {
		IEnumerable<Integer> values = Enumerable.of(1, 2, 3, 4, 5, 6, 7);
		int actual = values.count(n -> n % 2 == 0);
		Assert.assertEquals(actual, 3);
	}
}
