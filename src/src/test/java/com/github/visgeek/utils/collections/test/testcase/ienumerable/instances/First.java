package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class First {
	@Test
	public void test_first01_01() {
		try {
			Enumerable.empty(Integer.class).first();
			Assert.fail();
		} catch (Exception e) {
			//
		}
	}

	@Test
	public void test_first01_02() {
		int n = Enumerable.of(1, 2, 3, 4).first();
		Assert.assertEquals(1, n);
	}

	@Test
	public void test_first01_03() {
		int n = Enumerable.range(1, 4).first();
		Assert.assertEquals(1, n);
	}

	@Test
	public void test_first02_01() {
		try {
			Enumerable.empty(Integer.class).first(n -> n % 2 == 0);
			Assert.fail();
		} catch (Exception e) {
			//
		}
	}

	@Test
	public void test_first02_02() {
		int actual = Enumerable.of(1, 2, 3, 4).first(n -> n % 2 == 0);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_first02_03() {
		int actual = Enumerable.range(1, 4).first(arg -> arg % 2 == 0);
		Assert.assertEquals(2, actual);
	}
}
