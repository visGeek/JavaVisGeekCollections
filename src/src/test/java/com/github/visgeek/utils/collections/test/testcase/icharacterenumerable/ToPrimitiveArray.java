package com.github.visgeek.utils.collections.test.testcase.icharacterenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.ICharacterEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		ICharacterEnumerable source = Enumerable.of(null, 'a', 'b', 'c').selectCharacter(n -> n);
		char[] expected = new char[] { '\0', 'a', 'b', 'c' };

		char[] actual = source.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
