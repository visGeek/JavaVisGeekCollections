package com.github.visgeek.utils.test;

import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.functions.Func1;
import com.github.visgeek.utils.testing.Assert2;

public class Func1Test {
	@Test
	public void normal() {
		Func1<Integer, List<Integer>> func = (arg1) -> Functions.toList(arg1);
		Integer[] expected = new Integer[] { 1 };
		List<Integer> actual = func.func(1);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void partialApply() {
		Func1<Integer, List<Integer>> func = (arg1) -> Functions.toList(arg1);
		Integer[] expected = new Integer[] { 1 };
		List<Integer> actual = func.partialApply(1).func();

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException01() {
		Func1<Integer, List<Integer>> func = Func1.create((arg1) -> Functions.toListOrThrow(false, arg1));
		Integer[] expected = new Integer[] { 1 };
		List<Integer> actual = func.func(1);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException02() {
		Func1<Integer, List<Integer>> func = Func1.create((arg1) -> Functions.toListOrThrow(true));
		Assert2.assertExceptionThrown(RuntimeException.class, () -> func.func(1));
	}
}
