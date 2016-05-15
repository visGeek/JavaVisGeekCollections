package com.github.visgeek.utils.test;

import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.functions.Func7;
import com.github.visgeek.utils.testing.Assert2;

public class Func7Test {
	@Test
	public void normal() {
		Func7<Integer, Integer, Integer, Integer, Integer, Integer, Integer, List<Integer>> func = (arg1, arg2, arg3, arg4, arg5, arg6, arg7) -> Functions.toList(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		Integer[] expected = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
		List<Integer> actual = func.func(1, 2, 3, 4, 5, 6, 7);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void partialApply() {
		Func7<Integer, Integer, Integer, Integer, Integer, Integer, Integer, List<Integer>> func = (arg1, arg2, arg3, arg4, arg5, arg6, arg7) -> Functions.toList(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		Integer[] expected = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
		List<Integer> actual = func.partialApply(1).partialApply(2).partialApply(3).partialApply(4).partialApply(5).partialApply(6).partialApply(7).func();

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void curry() {
		Func7<Integer, Integer, Integer, Integer, Integer, Integer, Integer, List<Integer>> func = (arg1, arg2, arg3, arg4, arg5, arg6, arg7) -> Functions.toList(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		Integer[] expected = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
		List<Integer> actual = func.curry().func(1).func(2).func(3).func(4).func(5).func(6).func(7);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException01() {
		Func7<Integer, Integer, Integer, Integer, Integer, Integer, Integer, List<Integer>> func = Func7.create((arg1, arg2, arg3, arg4, arg5, arg6, arg7) -> Functions.toListOrThrow(false, arg1, arg2, arg3, arg4, arg5, arg6, arg7));
		Integer[] expected = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
		List<Integer> actual = func.func(1, 2, 3, 4, 5, 6, 7);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException02() {
		Func7<Integer, Integer, Integer, Integer, Integer, Integer, Integer, List<Integer>> func = Func7.create((arg1, arg2, arg3, arg4, arg5, arg6, arg7) -> Functions.toListOrThrow(true));
		Assert2.assertExceptionThrown(RuntimeException.class, () -> func.func(1, 2, 3, 4, 5, 6, 7));
	}
}
