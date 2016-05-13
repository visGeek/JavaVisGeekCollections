package com.github.visgeek.utils.collections.test.testcase.ilistenumerable;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Reverse {
	@Test
	public void test() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		IEnumerable<Integer> actual = source.reverse();
		Assert2.assertSequanceEquals(actual, 3, 2, 1);
	}
}
