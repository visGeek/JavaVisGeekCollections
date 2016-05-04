package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class Sum {
	@Test
	public void test_sum01() {
		int actual = Enumerable.ofInteger(1, 2, 3, 4).sum();
		Assert.assertEquals(1 + 2 + 3 + 4, actual);
	}

	@Test
	public void test_sum02() {
		double actual = Enumerable.ofDouble(1.0, 2.0, 3.0, 4.0).sum();
		Assert.assertEquals(1.0 + 2.0 + 3.0 + 4.0, actual, 0.0);
	}

	@Test
	public void test_sumDouble01() {
		double actual = Enumerable.of(1.0, 2.0, 3.0, 4.0).sumDouble(n -> n);
		Assert.assertEquals(1.0 + 2.0 + 3.0 + 4.0, actual, 0);
	}

	@Test
	public void test_sumInt01() {
		int actual = Enumerable.of(1, 2, 3, 4).sumInt(n -> n);
		Assert.assertEquals(1 + 2 + 3 + 4, actual);
	}

	@Test
	public void test_sumLong01() {
		long actual = Enumerable.of(1L, 2L, 3L, 4L).sumLong(n -> n);
		Assert.assertEquals(1L + 2L + 3L + 4L, actual);
	}
}
