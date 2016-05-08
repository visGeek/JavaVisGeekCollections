package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class FirstOrDefault {
	@Test
	public void test_firstOrDefault01_01() {
		Integer actual = Enumerable.empty(Integer.class).firstOrDefault();
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_firstOrDefault02_01() {
		int actual = Enumerable.of(1, 2, 3).firstOrDefault(4);
		Assert.assertEquals(1, actual);
	}

	@Test
	public void test_firstOrDefault02_02() {
		int actual = Enumerable.empty(Integer.class).firstOrDefault(4);
		Assert.assertEquals(4, actual);
	}

	@Test
	public void test_firstOrDefault03_01() {
		int actual = Enumerable.of(1, 2, 3).firstOrDefault(arg -> arg == 2);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_firstOrDefault03_02() {
		Integer actual = Enumerable.of(1, 2, 3).firstOrDefault(arg -> arg == 4);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_firstOrDefault03_03() {
		Integer actual = Enumerable.empty(Integer.class).firstOrDefault(arg -> arg == 4);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_firstOrDefault004_01() {
		int actual = Enumerable.of(1, 2, 3).firstOrDefault(arg -> arg == 4, 5);
		Assert.assertEquals(5, actual);
	}
}
