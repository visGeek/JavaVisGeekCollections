package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class ElementAtOrDefault {
	@Test
	public void test_elementAtOrDefault01_01() {
		int actual = Enumerable.of(1, 2, 3).elementAtOrDefault(1);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_elementAtOrDefault01_02() {
		Integer actual = Enumerable.of(1, 2, 3).elementAtOrDefault(-1);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_elementAtOrDefault01_03() {
		Integer actual = Enumerable.of(1, 2, 3).elementAtOrDefault(3);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_elementAtOrDefault02_01() {
		int actual = Enumerable.range(1, 3).elementAtOrDefault(1);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_elementAtOrDefault02_02() {
		Integer actual = Enumerable.range(1, 3).elementAtOrDefault(-1);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_elementAtOrDefault02_03() {
		Integer actual = Enumerable.range(1, 3).elementAtOrDefault(3);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_elementAtOrDefault03_01() {
		int actual = Enumerable.of(1, 2, 3).elementAtOrDefault(1, 4);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_elementAtOrDefault03_02() {
		int actual = Enumerable.of(Arrays.asList(1, 2, 3)).elementAtOrDefault(-1, 4);
		Assert.assertEquals(4, actual);
	}

	@Test
	public void test_elementAtOrDefault03_03() {
		int actual = Enumerable.of(Arrays.asList(1, 2, 3)).elementAtOrDefault(3, 4);
		Assert.assertEquals(4, actual);
	}

	@Test
	public void test_elementAtOrDefault04_01() {
		int actual = Enumerable.range(1, 3).elementAtOrDefault(1, 4);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_elementAtOrDefault04_02() {
		int actual = Enumerable.range(1, 3).elementAtOrDefault(-1, 4);
		Assert.assertEquals(4, actual);
	}

	@Test
	public void test_elementAtOrDefault04_03() {
		int actual = Enumerable.range(1, 3).elementAtOrDefault(3, 4);
		Assert.assertEquals(4, actual);
	}
}
