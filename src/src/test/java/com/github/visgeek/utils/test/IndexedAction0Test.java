package com.github.visgeek.utils.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.functions.IndexedAction0;
import com.github.visgeek.utils.testing.Assert2;

public class IndexedAction0Test {
	@Test
	public void normal() {
		List<Integer> values = new ArrayList<>();

		IndexedAction0 action = index -> Functions.addTo(values, 1);
		Integer[] expected = new Integer[] { 1 };
		action.action(0);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void wrapThrowsException01() {
		List<Integer> values = new ArrayList<>();

		IndexedAction0 action = IndexedAction0.create(index -> Functions.addToOrThrow(values, 1));
		Integer[] expected = new Integer[] { 1 };
		action.action(0);

		Assert2.assertSequanceEquals(values, expected);
	}

	@Test
	public void wrapThrowsException02() {
		IndexedAction0 action = IndexedAction0.create(index -> Functions.addToOrThrow(null));
		Assert2.assertExceptionThrown(RuntimeException.class, () -> action.action(0));
	}
}
