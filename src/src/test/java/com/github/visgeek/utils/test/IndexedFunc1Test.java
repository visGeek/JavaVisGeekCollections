package com.github.visgeek.utils.test;

import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.IndexedFunc1;
import com.github.visgeek.utils.testing.Assert2;

public class IndexedFunc1Test {
	@Test
	public void normal() {
		IndexedFunc1<Integer, List<Integer>> func = (arg1, index) -> Functions.toList(arg1);
		Integer[] expected = new Integer[] { 1 };
		List<Integer> actual = func.func(1, 0);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void partialApply() {
		IndexedFunc1<Integer, List<Integer>> func = (arg1, index) -> Functions.toList(arg1);
		Integer[] expected = new Integer[] { 1 };
		List<Integer> actual = func.partialApply(1).func(0);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException01() {
		IndexedFunc1<Integer, List<Integer>> func = IndexedFunc1.create((arg1, index) -> Functions.toListOrThrow(false, arg1));
		Integer[] expected = new Integer[] { 1 };
		List<Integer> actual = func.func(1, 0);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException02() {
		IndexedFunc1<Integer, List<Integer>> func = IndexedFunc1.create((arg1, index) -> Functions.toListOrThrow(true));
		Assert2.assertExceptionThrown(RuntimeException.class, () -> func.func(1, 0));
	}
}
