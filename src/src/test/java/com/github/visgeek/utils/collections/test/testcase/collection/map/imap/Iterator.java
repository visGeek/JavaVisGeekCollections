package com.github.visgeek.utils.collections.test.testcase.collection.map.imap;

import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.testing.Assert2;

public class Iterator {
	@Test
	public void test() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		Assert2.assertSequanceEquals(map.select(kv -> kv.getKey()).orderByDefaultKey(), 1, 2, 3);
	}
}
