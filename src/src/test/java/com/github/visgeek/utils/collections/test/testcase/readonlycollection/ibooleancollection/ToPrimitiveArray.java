package com.github.visgeek.utils.collections.test.testcase.readonlycollection.ibooleancollection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IBooleanEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		Boolean[] source = new Boolean[] { null, false, true, true };
		boolean[] expected = new boolean[] { false, false, true, true };

		IBooleanEnumerable enumerable = Enumerable.of(source);
		boolean[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
