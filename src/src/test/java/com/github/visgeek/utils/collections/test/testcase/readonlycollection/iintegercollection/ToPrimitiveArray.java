package com.github.visgeek.utils.collections.test.testcase.readonlycollection.iintegercollection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IIntegerEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		Integer[] source = new Integer[] { null, 1, 2, 3 };
		int[] expected = new int[] { 0, 1, 2, 3 };

		IIntegerEnumerable enumerable = Enumerable.of(source);
		int[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
