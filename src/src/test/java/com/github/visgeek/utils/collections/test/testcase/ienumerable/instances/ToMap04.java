package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func2;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ToMap04 {
	@Test
	public void keySelectorIsNull() {
		IEnumerable<String> source = () -> Enumerable.of(new String[] { "a", "b", "c" }).iterator();
		Func2<String, Integer, String> keySelector = null;
		Func2<String, Integer, String> valueSelector = (str, idx) -> String.format("key:%d%s", idx, str);

		Action0 action = () -> source.toMap(keySelector, valueSelector);
		Assert2.assertNullPointerExceptionThrown("keySelector", action);
	}

	@Test
	public void valueSelectorIsNull() {
		IEnumerable<String> source = () -> Enumerable.of(new String[] { "a", "b", "c" }).iterator();
		Func2<String, Integer, String> keySelector = (str, idx) -> String.format("key:%d%s", idx, str);
		Func2<String, Integer, String> valueSelector = null;

		Action0 action = () -> source.toMap(keySelector, valueSelector);
		Assert2.assertNullPointerExceptionThrown("valueSelector", action);
	}

	@Test
	public void keyAlreadExists() {
		IEnumerable<String> source = () -> Enumerable.of(new String[] { "a", "b", "c" }).iterator();
		Func2<String, Integer, String> keySelector = (str, idx) -> "0";
		Func2<String, Integer, String> valueSelector = (str, idx) -> String.format("key:%d%s", idx, str);

		Action0 action = () -> source.toMap(keySelector, valueSelector);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	@Test
	public void test() {
		IEnumerable<String> source = () -> Enumerable.of(new String[] { "a", "b", "c" }).iterator();
		Func2<String, Integer, String> keySelector = (str, idx) -> String.format("key:%d%s", idx, str);
		Func2<String, Integer, String> valueSelector = (str, idx) -> String.format("val:%d%s", idx, str);

		EnumerableMap<String, String> actual = source.toMap(keySelector, valueSelector);

		Assert.assertEquals(actual.size(), 3);
		equalse(actual, "key:0a", "val:0a");
		equalse(actual, "key:1b", "val:1b");
		equalse(actual, "key:2c", "val:2c");
	}

	private void equalse(EnumerableMap<String, String> map, String key, String value) {
		Assert.assertEquals(value, map.getValue(key));
	}
}
