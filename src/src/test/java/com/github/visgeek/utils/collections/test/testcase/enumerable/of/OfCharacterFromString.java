package com.github.visgeek.utils.collections.test.testcase.enumerable.of;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.ICharacterEnumerable;

public class OfCharacterFromString {
	@Test
	public void stringEmpty() {
		String source = "";

		ICharacterEnumerable enumerable = Enumerable.ofCharacter(source);
		char[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(source.toCharArray(), actual);
	}

	@Test
	public void stringNotEmpty() {
		String source = "abc";

		ICharacterEnumerable enumerable = Enumerable.ofCharacter(source);
		char[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(source.toCharArray(), actual);
	}
}
