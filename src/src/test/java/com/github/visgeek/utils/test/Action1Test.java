package com.github.visgeek.utils.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.functions.Action1;
import com.github.visgeek.utils.testing.Assert2;

public class Action1Test {
	@Test
	public void normal() {
		List<Integer> values = new ArrayList<>();

		Action1<Integer> action = (arg1) -> Functions.addTo(values, arg1);
		Integer[] expected = new Integer[] { 1 };
		action.action(1);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void partialApply() {
		List<Integer> values = new ArrayList<>();

		Action1<Integer> action = (arg1) -> Functions.addTo(values, arg1);
		Integer[] expected = new Integer[] { 1 };
		action.partialApply(1).action();

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void wrapThrowsException01() {
		List<Integer> values = new ArrayList<>();

		Action1<Integer> action = Action1.create((arg1) -> Functions.addToOrThrow(values, arg1));
		Integer[] expected = new Integer[] { 1 };
		action.action(1);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void wrapThrowsException02() {
		Action1<Integer> action = Action1.create((arg1) -> Functions.addToOrThrow(null));
		Assert2.assertExceptionThrown(RuntimeException.class, () -> action.action(1));
	}
}
