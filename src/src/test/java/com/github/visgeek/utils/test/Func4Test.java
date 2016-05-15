package com.github.visgeek.utils.test;

import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.functions.Func4;
import com.github.visgeek.utils.testing.Assert2;

public class Func4Test {
	@Test
	public void normal() {
		Func4<Integer, Integer, Integer, Integer, List<Integer>> func = (arg1, arg2, arg3, arg4) -> Functions.toList(arg1, arg2, arg3, arg4);
		Integer[] expected = new Integer[] { 1, 2, 3, 4 };
		List<Integer> actual = func.func(1, 2, 3, 4);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void partialApply() {
		Func4<Integer, Integer, Integer, Integer, List<Integer>> func = (arg1, arg2, arg3, arg4) -> Functions.toList(arg1, arg2, arg3, arg4);
		Integer[] expected = new Integer[] { 1, 2, 3, 4 };
		List<Integer> actual = func.partialApply(1).partialApply(2).partialApply(3).partialApply(4).func();

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void curry() {
		Func4<Integer, Integer, Integer, Integer, List<Integer>> func = (arg1, arg2, arg3, arg4) -> Functions.toList(arg1, arg2, arg3, arg4);
		Integer[] expected = new Integer[] { 1, 2, 3, 4 };
		List<Integer> actual = func.curry().func(1).func(2).func(3).func(4);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException01() {
		Func4<Integer, Integer, Integer, Integer, List<Integer>> func = Func4.create((arg1, arg2, arg3, arg4) -> Functions.toListOrThrow(false, arg1, arg2, arg3, arg4));
		Integer[] expected = new Integer[] { 1, 2, 3, 4 };
		List<Integer> actual = func.func(1, 2, 3, 4);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException02() {
		Func4<Integer, Integer, Integer, Integer, List<Integer>> func = Func4.create((arg1, arg2, arg3, arg4) -> Functions.toListOrThrow(true));
		Assert2.assertExceptionThrown(RuntimeException.class, () -> func.func(1, 2, 3, 4));
	}
}
