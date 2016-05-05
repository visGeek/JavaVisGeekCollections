package com.github.visgeek.utils.collections.test.testcase.ienumerable.statics;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class OfCharacter {
	@Test
	public void primitiveArray_empty() {
		char[] values = new char[] {};
		IEnumerable<Character> actual = Enumerable.ofCharacter(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void primitiveArray_normal() {
		char[] values = new char[] { 'a', 'b', 'c' };
		IEnumerable<Character> actual = Enumerable.ofCharacter(values);

		Assert2.assertSequanceEquals(actual, 'a', 'b', 'c');
	}

	@Test
	public void string_empty() {
		String values = "";
		IEnumerable<Character> actual = Enumerable.ofCharacter(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void string_normal() {
		String values = "abc";
		IEnumerable<Character> actual = Enumerable.ofCharacter(values);

		Assert2.assertSequanceEquals(actual, 'a', 'b', 'c');
	}
}
