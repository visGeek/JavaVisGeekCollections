package com.github.visgeek.utils.collections.test.testcase.readonlycollection.icharactercollection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.ICharacterEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		Character[] source = new Character[] { null, 'a', 'b', 'c' };
		char[] expected = new char[] { '\0', 'a', 'b', 'c' };

		ICharacterEnumerable enumerable = Enumerable.of(source);
		char[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
