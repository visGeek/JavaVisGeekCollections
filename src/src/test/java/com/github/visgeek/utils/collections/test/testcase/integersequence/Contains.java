package com.github.visgeek.utils.collections.test.testcase.integersequence;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Contains {
	@Test
	public void containsTarget() {
		IEnumerable<Integer> source = Enumerable.forTo(1, 3);
		Integer target = 2;
		boolean expected = true;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void targetIsNull() {
		IEnumerable<Integer> source = Enumerable.forTo(1, 3);
		Integer target = null;
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notContainsTarget01() {
		IEnumerable<Integer> source = Enumerable.forTo(1, 3);
		Integer target = 0;
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notContainsTarget02() {
		IEnumerable<Integer> source = Enumerable.forTo(1, 3);
		Integer target = 4;
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}
}
