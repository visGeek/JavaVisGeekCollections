package com.github.visgeek.utils.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.testing.Assert2;

public class Action0Test {
	@Test
	public void normal() {
		List<Integer> values = new ArrayList<>();

		Action0 action = () -> Functions.addTo(values, 1);
		Integer[] expected = new Integer[] { 1 };
		action.action();

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void wrapThrowsException01() {
		List<Integer> values = new ArrayList<>();

		Action0 action = Action0.create(() -> Functions.addToOrThrow(values, 1));
		Integer[] expected = new Integer[] { 1 };
		action.action();

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void wrapThrowsException02() {
		Action0 action = Action0.create(() -> Functions.addToOrThrow(null));
		Assert2.assertExceptionThrown(RuntimeException.class, () -> action.action());
	}
}
