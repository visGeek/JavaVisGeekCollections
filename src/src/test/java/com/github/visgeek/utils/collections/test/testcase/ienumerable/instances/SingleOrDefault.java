package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class SingleOrDefault {
	@Test
	public void test_singleOrDefault01_01() {
		int actual = Enumerable.of(2).singleOrDefault();
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_singleOrDefault01_02() {
		Integer actual = Enumerable.empty(Integer.class).singleOrDefault();
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_singleOrDefault01_03() {
		Integer actual = Enumerable.of(1, 2, 3).singleOrDefault();
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_singleOrDefault02_01() {
		int actual = Enumerable.of(2).singleOrDefault(3);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_singleOrDefault02_02() {
		int actual = Enumerable.empty(Integer.class).singleOrDefault(3);
		Assert.assertEquals(3, actual);
	}

	@Test
	public void test_singleOrDefault02_03() {
		int actual = Enumerable.of(1, 2, 3).singleOrDefault(4);
		Assert.assertEquals(4, actual);
	}

	@Test
	public void test_singleOrDefault03_01() {
		int actual = Enumerable.of(1, 2, 3).singleOrDefault(n -> n % 2 == 0);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_singleOrDefault03_02() {
		Integer actual = Enumerable.of(1, 3, 5).singleOrDefault(n -> n % 2 == 0);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_singleOrDefault03_03() {
		Integer actual = Enumerable.of(1, 2, 3, 4).singleOrDefault(n -> n % 2 == 0);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_singleOrDefault04_01() {
		int actual = Enumerable.of(1, 2, 3).singleOrDefault(n -> n % 2 == 0, 4);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_singleOrDefault04_02() {
		int actual = Enumerable.of(1, 3, 5).singleOrDefault(n -> n % 2 == 0, 7);
		Assert.assertEquals(7, actual);
	}

	@Test
	public void test_singleOrDefault04_03() {
		int actual = Enumerable.of(1, 2, 3, 4).singleOrDefault(n -> n % 2 == 0, 5);
		Assert.assertEquals(5, actual);
	}
}
