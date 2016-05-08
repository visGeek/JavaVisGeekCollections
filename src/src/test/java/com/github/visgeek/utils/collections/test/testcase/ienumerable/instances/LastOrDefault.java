package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class LastOrDefault {
	@Test
	public void test_lastOrDefault01_01() {
		int actual = Enumerable.of(1, 2, 3).lastOrDefault();
		Assert.assertEquals(3, actual);
	}

	@Test
	public void test_lastOrDefault01_02() {
		Integer actual = Enumerable.empty(Integer.class).lastOrDefault();
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_lastOrDefault02_01() {
		int actual = Enumerable.of(1, 2, 3).lastOrDefault(4);
		Assert.assertEquals(3, actual);
	}

	@Test
	public void test_lastOrDefault02_02() {
		int actual = Enumerable.empty(Integer.class).lastOrDefault(4);
		Assert.assertEquals(4, actual);
	}

	@Test
	public void test_lastOrDefault03_01() {
		int actual = Enumerable.of(1, 2, 3, 4, 5).lastOrDefault(arg -> arg % 2 == 0);
		Assert.assertEquals(4, actual);
	}

	@Test
	public void test_lastOrDefault03_02() {
		Integer actual = Enumerable.of(1, 2, 3).lastOrDefault(arg -> arg == 4);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_lastOrDefault04_01() {
		Integer actual = Enumerable.empty(Integer.class).lastOrDefault(arg -> arg == 4);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_lastOrDefault04_02() {
		int actual = Enumerable.of(1, 2, 3).lastOrDefault(arg -> arg == 4, 5);
		Assert.assertEquals(5, actual);
	}
}
