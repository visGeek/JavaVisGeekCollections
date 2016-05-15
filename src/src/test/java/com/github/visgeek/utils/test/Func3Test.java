package com.github.visgeek.utils.test;

import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.functions.Func3;
import com.github.visgeek.utils.testing.Assert2;

public class Func3Test {
	@Test
	public void normal() {
		Func3<Integer, Integer, Integer, List<Integer>> func = (arg1, arg2, arg3) -> Functions.toList(arg1, arg2, arg3);
		Integer[] expected = new Integer[] { 1, 2, 3 };
		List<Integer> actual = func.func(1, 2, 3);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void partialApply() {
		Func3<Integer, Integer, Integer, List<Integer>> func = (arg1, arg2, arg3) -> Functions.toList(arg1, arg2, arg3);
		Integer[] expected = new Integer[] { 1, 2, 3 };
		List<Integer> actual = func.partialApply(1).partialApply(2).partialApply(3).func();

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void curry() {
		Func3<Integer, Integer, Integer, List<Integer>> func = (arg1, arg2, arg3) -> Functions.toList(arg1, arg2, arg3);
		Integer[] expected = new Integer[] { 1, 2, 3 };
		List<Integer> actual = func.curry().func(1).func(2).func(3);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException01() {
		Func3<Integer, Integer, Integer, List<Integer>> func = Func3.create((arg1, arg2, arg3) -> Functions.toListOrThrow(false, arg1, arg2, arg3));
		Integer[] expected = new Integer[] { 1, 2, 3 };
		List<Integer> actual = func.func(1, 2, 3);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException02() {
		Func3<Integer, Integer, Integer, List<Integer>> func = Func3.create((arg1, arg2, arg3) -> Functions.toListOrThrow(true));
		Assert2.assertExceptionThrown(RuntimeException.class, () -> func.func(1, 2, 3));
	}
}
