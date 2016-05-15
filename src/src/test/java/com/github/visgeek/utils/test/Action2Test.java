package com.github.visgeek.utils.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.functions.Action2;
import com.github.visgeek.utils.testing.Assert2;

public class Action2Test {
	@Test
	public void normal() {
		List<Integer> values = new ArrayList<>();

		Action2<Integer, Integer> action = (arg1, arg2) -> Functions.addTo(values, arg1, arg2);
		Integer[] expected = new Integer[] { 1, 2 };
		action.action(1, 2);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void partialApply() {
		List<Integer> values = new ArrayList<>();

		Action2<Integer, Integer> action = (arg1, arg2) -> Functions.addTo(values, arg1, arg2);
		Integer[] expected = new Integer[] { 1, 2 };
		action.partialApply(1).partialApply(2).action();

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void curry() {
		List<Integer> values = new ArrayList<>();

		Action2<Integer, Integer> action = (arg1, arg2) -> Functions.addTo(values, arg1, arg2);
		Integer[] expected = new Integer[] { 1, 2 };
		action.curry().func(1).action(2);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void wrapThrowsException01() {
		List<Integer> values = new ArrayList<>();

		Action2<Integer, Integer> action = Action2.create((arg1, arg2) -> Functions.addToOrThrow(values, arg1, arg2));
		Integer[] expected = new Integer[] { 1, 2 };
		action.action(1, 2);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void wrapThrowsException02() {
		Action2<Integer, Integer> action = Action2.create((arg1, arg2) -> Functions.addToOrThrow(null));
		Assert2.assertExceptionThrown(RuntimeException.class, () -> action.action(1, 2));
	}
}
