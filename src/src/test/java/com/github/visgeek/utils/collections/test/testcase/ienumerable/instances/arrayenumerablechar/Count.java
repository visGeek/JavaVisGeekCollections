package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.arrayenumerablechar;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Count {
	@Test
	public void testSuccess() {
		IEnumerable<Character> source = Enumerable.of('a', 'b', 'c');
		int expected = 3;

		int actual = source.count();
		Assert.assertEquals(expected, actual);
	}
}
