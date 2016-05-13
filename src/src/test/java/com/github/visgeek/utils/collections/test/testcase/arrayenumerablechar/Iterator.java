package com.github.visgeek.utils.collections.test.testcase.arrayenumerablechar;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Iterator {
	@Test
	public void test() {
		IEnumerable<Character> source = Enumerable.of('a', 'b', 'c');
		Assert2.assertSequanceEquals(source, 'a', 'b', 'c');
	}
}
