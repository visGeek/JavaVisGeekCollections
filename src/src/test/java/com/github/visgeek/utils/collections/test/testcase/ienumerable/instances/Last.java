package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class Last {
	@Test
	public void test_last01_01() {
		try {
			Enumerable.empty(Integer.class).last();
			Assert.fail();
		} catch (Exception e) {
			//
		}
	}

	@Test
	public void test_last01_02() {
		int actual = Enumerable.of(1, 2, 3, 4).last();
		Assert.assertEquals(4, actual);
	}

	@Test
	public void test_last01_03() {
		int actual = Enumerable.range(1, 4).last();
		Assert.assertEquals(4, actual);
	}

	@Test
	public void test_last02_01() {
		try {
			Enumerable.empty(Integer.class).last(n -> n % 2 == 0);
			Assert.fail();
		} catch (Exception e) {
			//
		}
	}

	@Test
	public void test_last02_02() {
		int actual = Enumerable.of(1, 2, 3, 4, 5).last(n -> n % 2 == 0);
		Assert.assertEquals(4, actual);
	}

	@Test
	public void test_last02_03() {
		int actual = Enumerable.range(1, 5).last(arg -> arg % 2 == 0);
		Assert.assertEquals(4, actual);
	}
}
