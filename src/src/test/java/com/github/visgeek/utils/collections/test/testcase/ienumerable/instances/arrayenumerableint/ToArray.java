package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.arrayenumerableint;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IIntegerEnumerable;

public class ToArray {
	@Test
	public void test() {
		IIntegerEnumerable source = Enumerable.of(1, 2, 3);
		int[] expected = new int[] { 1, 2, 3 };

		int[] actual = source.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
