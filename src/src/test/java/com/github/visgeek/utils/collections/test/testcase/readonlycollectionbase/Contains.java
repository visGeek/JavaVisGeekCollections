package com.github.visgeek.utils.collections.test.testcase.readonlycollectionbase;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Contains {
	@Test
	public void contains() {
		Integer[] source = new Integer[] { 1, 2, 3, null };
		Integer target = 2;
		boolean expected = true;

		boolean actual = Enumerable.of(source).contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notContains() {
		Integer[] source = new Integer[] { 1, 2, 3, null };
		Integer target = 4;
		boolean expected = false;

		IEnumerable<Integer> enumerable = Enumerable.of(source);
		boolean actual = enumerable.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void nullContains() {
		Integer[] source = new Integer[] { 1, 2, 3, null };
		Integer target = null;
		boolean expected = true;

		IEnumerable<Integer> enumerable = Enumerable.of(source);
		boolean actual = enumerable.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void nullNotContains() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		Integer target = null;
		boolean expected = false;

		IEnumerable<Integer> enumerable = Enumerable.of(source);
		boolean actual = enumerable.contains(target);
		Assert.assertEquals(expected, actual);
	}
}
