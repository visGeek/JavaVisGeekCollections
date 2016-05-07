package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.EnumerableMap;

public class ToMap {
	@Test
	public void test_toMap01() {
		EnumerableMap<Integer, Integer> actual = Enumerable.of(1, 2, 3).toMap(n -> n);
		Assert.assertEquals(3, actual.size());
		Assert.assertEquals(1, (int) actual.getValue(1));
		Assert.assertEquals(2, (int) actual.getValue(2));
		Assert.assertEquals(3, (int) actual.getValue(3));
	}

	@Test
	public void test_toMap02() {
		EnumerableMap<Integer, Integer> actual = Enumerable.of(1, 2, 3).toMap((n, idx) -> idx);
		Assert.assertEquals(3, actual.size());
		Assert.assertEquals(1, (int) actual.getValue(0));
		Assert.assertEquals(2, (int) actual.getValue(1));
		Assert.assertEquals(3, (int) actual.getValue(2));
	}

	@Test
	public void test_toMap03() {
		try {
			Enumerable.of(1, 1, 3).toMap(n -> n);
			Assert.fail();
		} catch (IllegalArgumentException ex) {
			//
		}
	}
}
