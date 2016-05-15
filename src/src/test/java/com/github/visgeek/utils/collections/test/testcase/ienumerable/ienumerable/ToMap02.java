package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.functions.IndexedFunc1;
import com.github.visgeek.utils.testing.Assert2;

public class ToMap02 {
	@Test
	public void keySelectorIsNull() {
		IEnumerable<String> source = () -> Enumerable.of(new String[] { "a", "b", "c" }).iterator();
		IndexedFunc1<String, Integer> keySelector = null;

		Action0 action = () -> source.toMap(keySelector);
		Assert2.assertNullPointerExceptionThrown("keySelector", action);
	}

	@Test
	public void keyAlreadExists() {
		IEnumerable<String> source = () -> Enumerable.of(new String[] { "a", "b", "c" }).iterator();
		IndexedFunc1<String, Integer> keySelector = (str, idx) -> 0;

		Action0 action = () -> source.toMap(keySelector);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	@Test
	public void test() {
		IEnumerable<String> source = () -> Enumerable.of(new String[] { "a", "b", "c" }).iterator();
		IndexedFunc1<String, Integer> keySelector = (str, idx) -> idx;

		EnumerableMap<Integer, String> actual = source.toMap(keySelector);

		Assert.assertEquals(actual.size(), 3);
		equalse(actual, 0, "a");
		equalse(actual, 1, "b");
		equalse(actual, 2, "c");
	}

	private void equalse(EnumerableMap<Integer, String> map, int key, String value) {
		Assert.assertEquals(value, map.getValue(key));
	}
}
