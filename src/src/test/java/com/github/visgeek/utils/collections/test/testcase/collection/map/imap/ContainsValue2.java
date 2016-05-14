package com.github.visgeek.utils.collections.test.testcase.collection.map.imap;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableMap;

public class ContainsValue2 {
	@Test
	public void test() {
		EnumerableMap<String, Integer> map = new EnumerableMap<>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);

		Assert.assertEquals(true, map.containsValue2(1));
		Assert.assertEquals(true, map.containsValue2(2));
		Assert.assertEquals(true, map.containsValue2(3));
		Assert.assertEquals(false, map.containsValue2(4));
	}
}
