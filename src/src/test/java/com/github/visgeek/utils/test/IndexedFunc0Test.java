package com.github.visgeek.utils.test;

import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.functions.IndexedFunc0;
import com.github.visgeek.utils.testing.Assert2;

public class IndexedFunc0Test {
	@Test
	public void normal() {
		IndexedFunc0<List<Integer>> func = (index) -> Functions.toList(1);
		Integer[] expected = new Integer[] { 1 };
		List<Integer> actual = func.func(0);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException01() {
		IndexedFunc0<List<Integer>> func = IndexedFunc0.create((index) -> Functions.toListOrThrow(false, 1));
		Integer[] expected = new Integer[] { 1 };
		List<Integer> actual = func.func(0);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException02() {
		IndexedFunc0<List<Integer>> func = IndexedFunc0.create((index) -> Functions.toListOrThrow(true));
		Assert2.assertExceptionThrown(RuntimeException.class, () -> func.func(0));
	}
}
