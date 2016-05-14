package com.github.visgeek.utils.collections.test.testcase.collection.map.imap;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableMap;

public class ContainsKey2 {
	@Test
	public void test() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		Assert.assertEquals(true, map.containsKey2(1));
		Assert.assertEquals(true, map.containsKey2(2));
		Assert.assertEquals(true, map.containsKey2(3));
		Assert.assertEquals(false, map.containsKey2(4));
	}
}
