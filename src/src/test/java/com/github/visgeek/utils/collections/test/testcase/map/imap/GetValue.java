package com.github.visgeek.utils.collections.test.testcase.map.imap;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableMap;

public class GetValue {
	@Test
	public void test() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		Assert.assertEquals("a", map.getValue(1));
		Assert.assertEquals("b", map.getValue(2));
		Assert.assertEquals("c", map.getValue(3));
		Assert.assertEquals(null, map.getValue(4));
	}
}
