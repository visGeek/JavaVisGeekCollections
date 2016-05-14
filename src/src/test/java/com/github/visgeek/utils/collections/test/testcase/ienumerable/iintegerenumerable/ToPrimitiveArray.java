package com.github.visgeek.utils.collections.test.testcase.ienumerable.iintegerenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IIntegerEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		IIntegerEnumerable source = Enumerable.of(null, 1, 2, 3).selectInteger(n -> n);
		int[] expected = new int[] { 0, 1, 2, 3 };

		int[] actual = source.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
