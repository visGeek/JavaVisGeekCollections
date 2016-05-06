package com.github.visgeek.utils.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.Action4;
import com.github.visgeek.utils.testing.Assert2;

public class Action4Test {
	@Test
	public void normal() {
		List<Integer> values = new ArrayList<>();

		Action4<Integer, Integer, Integer, Integer> action = (arg1, arg2, arg3, arg4) -> Functions.addTo(values, arg1, arg2, arg3, arg4);
		Integer[] expected = new Integer[] { 1, 2, 3, 4 };
		action.action(1, 2, 3, 4);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void partialApply() {
		List<Integer> values = new ArrayList<>();

		Action4<Integer, Integer, Integer, Integer> action = (arg1, arg2, arg3, arg4) -> Functions.addTo(values, arg1, arg2, arg3, arg4);
		Integer[] expected = new Integer[] { 1, 2, 3, 4 };
		action.partialApply(1).partialApply(2).partialApply(3).partialApply(4).action();

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void curry() {
		List<Integer> values = new ArrayList<>();

		Action4<Integer, Integer, Integer, Integer> action = (arg1, arg2, arg3, arg4) -> Functions.addTo(values, arg1, arg2, arg3, arg4);
		Integer[] expected = new Integer[] { 1, 2, 3, 4 };
		action.curry().func(1).func(2).func(3).action(4);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void wrapThrowsException01() {
		List<Integer> values = new ArrayList<>();

		Action4<Integer, Integer, Integer, Integer> action = Action4.create((arg1, arg2, arg3, arg4) -> Functions.addToOrThrow(values, arg1, arg2, arg3, arg4));
		Integer[] expected = new Integer[] { 1, 2, 3, 4 };
		action.action(1, 2, 3, 4);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void wrapThrowsException02() {
		Action4<Integer, Integer, Integer, Integer> action = Action4.create((arg1, arg2, arg3, arg4) -> Functions.addToOrThrow(null));
		Assert2.assertExceptionThrown(RuntimeException.class, () -> action.action(1, 2, 3, 4));
	}
}
