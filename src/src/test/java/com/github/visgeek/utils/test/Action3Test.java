package com.github.visgeek.utils.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.functions.Action3;
import com.github.visgeek.utils.testing.Assert2;

public class Action3Test {
	@Test
	public void normal() {
		List<Integer> values = new ArrayList<>();

		Action3<Integer, Integer, Integer> action = (arg1, arg2, arg3) -> Functions.addTo(values, arg1, arg2, arg3);
		Integer[] expected = new Integer[] { 1, 2, 3 };
		action.action(1, 2, 3);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void partialApply() {
		List<Integer> values = new ArrayList<>();

		Action3<Integer, Integer, Integer> action = (arg1, arg2, arg3) -> Functions.addTo(values, arg1, arg2, arg3);
		Integer[] expected = new Integer[] { 1, 2, 3 };
		action.partialApply(1).partialApply(2).partialApply(3).action();

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void curry() {
		List<Integer> values = new ArrayList<>();

		Action3<Integer, Integer, Integer> action = (arg1, arg2, arg3) -> Functions.addTo(values, arg1, arg2, arg3);
		Integer[] expected = new Integer[] { 1, 2, 3 };
		action.curry().func(1).func(2).action(3);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void wrapThrowsException01() {
		List<Integer> values = new ArrayList<>();

		Action3<Integer, Integer, Integer> action = Action3.create((arg1, arg2, arg3) -> Functions.addToOrThrow(values, arg1, arg2, arg3));
		Integer[] expected = new Integer[] { 1, 2, 3 };
		action.action(1, 2, 3);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void wrapThrowsException02() {
		Action3<Integer, Integer, Integer> action = Action3.create((arg1, arg2, arg3) -> Functions.addToOrThrow(null));
		Assert2.assertExceptionThrown(RuntimeException.class, () -> action.action(1, 2, 3));
	}
}
