package com.github.visgeek.utils.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.IndexedAction1;
import com.github.visgeek.utils.testing.Assert2;

public class IndexedAction1Test {
	@Test
	public void normal() {
		List<Integer> values = new ArrayList<>();

		IndexedAction1<Integer> action = (arg1, index) -> Functions.addTo(values, arg1);
		Integer[] expected = new Integer[] { 1 };
		action.action(1, 0);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void wrapThrowsException01() {
		List<Integer> values = new ArrayList<>();

		IndexedAction1<Integer> action = IndexedAction1.create((arg1, index) -> Functions.addToOrThrow(values, arg1));
		Integer[] expected = new Integer[] { 1 };
		action.action(1, 0);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void wrapThrowsException02() {
		IndexedAction1<Integer> action = IndexedAction1.create((arg1, index) -> Functions.addToOrThrow(null));
		Assert2.assertExceptionThrown(RuntimeException.class, () -> action.action(1, 0));
	}
}
