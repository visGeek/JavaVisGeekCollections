package com.github.visgeek.utils.test.testcase.collections.ienumerable.instances;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class ElementAt {
	@Test
	public void test_elementAt01_01() {
		int actual = Enumerable.of(Arrays.asList(1, 2, 3)).elementAt(1);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_elementAt01_02() {
		try {
			Enumerable.of(Arrays.asList(1, 2, 3)).elementAt(-1);
			Assert.fail();
		} catch (IndexOutOfBoundsException e) {
			//
		}
	}

	@Test
	public void test_elementAt01_03() {
		try {
			Enumerable.of(Arrays.asList(1, 2, 3)).elementAt(3);
			Assert.fail();
		} catch (IndexOutOfBoundsException e) {
			//
		}
	}

	@Test
	public void test_elementAt02_01() {
		int actual = Enumerable.range(1, 3).elementAt(1);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_elementAt02_02() {
		try {
			Enumerable.range(1, 3).elementAt(-1);
			Assert.fail();
		} catch (IndexOutOfBoundsException e) {
			//
		}
	}

	@Test
	public void test_elementAt02_03() {
		try {
			Enumerable.range(1, 3).elementAt(3);
			Assert.fail();
		} catch (IndexOutOfBoundsException e) {
			//
		}
	}
}
