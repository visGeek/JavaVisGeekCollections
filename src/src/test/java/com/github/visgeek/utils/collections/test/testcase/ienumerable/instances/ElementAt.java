package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ElementAt {
	@Test
	public void test_elementAt01_01() {
		int actual = Enumerable.of(Arrays.asList(1, 2, 3)).elementAt(1);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_elementAt01_02() {
		Assert2.assertExceptionThrown(IndexOutOfBoundsException.class, () -> Enumerable.of(Arrays.asList(1, 2, 3)).elementAt(-1));
	}

	@Test
	public void test_elementAt01_03() {
		Assert2.assertExceptionThrown(IndexOutOfBoundsException.class, () -> Enumerable.of(Arrays.asList(1, 2, 3)).elementAt(3));
	}

	@Test
	public void test_elementAt02_01() {
		int actual = Enumerable.range(1, 3).elementAt(1);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_elementAt02_02() {
		Assert2.assertExceptionThrown(IndexOutOfBoundsException.class, () -> Enumerable.range(1, 3).elementAt(-1));
	}

	@Test
	public void test_elementAt02_03() {
		Assert2.assertExceptionThrown(IndexOutOfBoundsException.class, () -> Enumerable.range(1, 3).elementAt(3));
	}
}
