package com.github.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class Single {
	@Test
	public void test_single01_01() {
		int value = Enumerable.of(2).single();
		Assert.assertEquals(2, value);
	}

	@Test
	public void test_single01_02() {
		try {
			Enumerable.empty(Integer.class).single();
			Assert.fail();
		} catch (Exception e) {
			//
		}
	}

	@Test
	public void test_single01_03() {
		try {
			Enumerable.of(1, 2).single();
			Assert.fail();
		} catch (Exception e) {
			//
		}
	}

	@Test
	public void test_single02_01() {
		int value = Enumerable.of(1, 2, 3).single(n -> n % 2 == 0);
		Assert.assertEquals(2, value);
	}

	@Test
	public void test_single02_02() {
		try {
			Enumerable.of(1, 3, 5).single(n -> n % 2 == 0);
			Assert.fail();
		} catch (Exception e) {
			//
		}
	}

	@Test
	public void test_single02_03() {
		try {
			Enumerable.of(1, 2, 3, 4).single(n -> n % 2 == 0);
			Assert.fail();
		} catch (Exception e) {
			//
		}
	}
}
