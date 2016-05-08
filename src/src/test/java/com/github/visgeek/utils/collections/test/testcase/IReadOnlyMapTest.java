package com.github.visgeek.utils.collections.test.testcase;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.collections.IReadOnlyMap;
import com.github.visgeek.utils.testing.Assert2;

public class IReadOnlyMapTest {
	@Test
	public void getValueOrThrow_keyExists() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "1");

		String actual = map.getValueOrThrow(1);
		Assert.assertEquals("1", actual);
	}

	@Test
	public void getValueOrThrow_keyNotExists() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		Assert2.assertExceptionThrown(IllegalArgumentException.class, () -> map.getValueOrThrow(1));
	}

	@Test
	public void getValueOrDefault01_keyExists() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "1");

		String actual = map.getValueOrDefault(1, () -> "2");
		Assert.assertEquals("1", actual);
	}

	@Test
	public void getValueOrDefault01_keyNotExists() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();

		String actual = map.getValueOrDefault(1, () -> "2");
		Assert.assertEquals("2", actual);
	}

	@Test
	public void getValueOrDefault02_keyExists() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "1");

		String actual = map.getValueOrDefault(1, key -> "!" + key);
		Assert.assertEquals("1", actual);
	}

	@Test
	public void getValueOrDefault02_keyNotExists() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();

		String actual = map.getValueOrDefault(1, key -> "!" + key);
		Assert.assertEquals("!1", actual);
	}

	@Test
	public void cast() {
		EnumerableMap<Integer, ArrayList<String>> map = new EnumerableMap<>();

		Action0 action = () -> {
			@SuppressWarnings("unused")
			IReadOnlyMap<Integer, Iterable<String>> map2 = IReadOnlyMap.cast(map);
		};

		Assert2.assertExceptionNotThrown(action);
	}
}
