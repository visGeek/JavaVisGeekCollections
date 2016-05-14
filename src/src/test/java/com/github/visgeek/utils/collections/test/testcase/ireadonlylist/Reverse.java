package com.github.visgeek.utils.collections.test.testcase.ireadonlylist;

import org.junit.Test;

import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Reverse {
	@Test
	public void test() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		Integer[] expected = new Integer[] { 3, 2, 1 };;

		TestList<Integer> collection = new TestList<>(source);
		IEnumerable<Integer> actual = collection.reverse();
		Assert2.assertSequanceEquals(actual, expected);
	}
}
