package com.github.visgeek.utils.test;

import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.Func0;
import com.github.visgeek.utils.testing.Assert2;

public class Func0Test {
	@Test
	public void normal() {
		Func0<List<Integer>> func = () -> Functions.toList(1);
		Integer[] expected = new Integer[] { 1 };
		List<Integer> actual = func.func();

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException01() {
		Func0<List<Integer>> func = Func0.create(() -> Functions.toListOrThrow(false, 1));
		Integer[] expected = new Integer[] { 1 };
		List<Integer> actual = func.func();

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException02() {
		Func0<List<Integer>> func = Func0.create(() -> Functions.toListOrThrow(true));
		Assert2.assertExceptionThrown(RuntimeException.class, () -> func.func());
	}
}
