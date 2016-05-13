package com.github.visgeek.utils.collections.test.testcase.arrayenumerablechar;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.ICharacterEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		ICharacterEnumerable source = Enumerable.of('a', 'b', 'c');
		char[] expected = new char[] { 'a', 'b', 'c' };

		char[] actual = source.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
