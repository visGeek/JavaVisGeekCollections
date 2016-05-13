package com.github.visgeek.utils.collections.test.testcase.arrayenumerablechar;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Contains {
	@Test
	public void contains() {
		IEnumerable<Character> source = Enumerable.of('a', 'b', 'c');
		Character target = 'b';
		boolean expected = true;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notContains() {
		IEnumerable<Character> source = Enumerable.of('a', 'b', 'c' );
		Character target = 'd';
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void argIsNull() {
		IEnumerable<Character> source = Enumerable.of('a', 'b', 'c' );
		Character target = null;
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}
}
