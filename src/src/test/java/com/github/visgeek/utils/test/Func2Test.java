package com.github.visgeek.utils.test;

import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.Func2;
import com.github.visgeek.utils.testing.Assert2;

public class Func2Test {
	@Test
	public void normal() {
		Func2<Integer, Integer, List<Integer>> func = (arg1, arg2) -> Functions.toList(arg1, arg2);
		Integer[] expected = new Integer[] { 1, 2 };
		List<Integer> actual = func.func(1, 2);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void partialApply() {
		Func2<Integer, Integer, List<Integer>> func = (arg1, arg2) -> Functions.toList(arg1, arg2);
		Integer[] expected = new Integer[] { 1, 2 };
		List<Integer> actual = func.partialApply(1).partialApply(2).func();

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void curry() {
		Func2<Integer, Integer, List<Integer>> func = (arg1, arg2) -> Functions.toList(arg1, arg2);
		Integer[] expected = new Integer[] { 1, 2 };
		List<Integer> actual = func.curry().func(1).func(2);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException01() {
		Func2<Integer, Integer, List<Integer>> func = Func2.create((arg1, arg2) -> Functions.toListOrThrow(false, arg1, arg2));
		Integer[] expected = new Integer[] { 1, 2 };
		List<Integer> actual = func.func(1, 2);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException02() {
		Func2<Integer, Integer, List<Integer>> func = Func2.create((arg1, arg2) -> Functions.toListOrThrow(true));
		Assert2.exceptionThrown(RuntimeException.class, () -> func.func(1, 2));
	}
}
