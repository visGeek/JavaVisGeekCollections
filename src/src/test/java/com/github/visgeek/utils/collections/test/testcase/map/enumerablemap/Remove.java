package com.github.visgeek.utils.collections.test.testcase.map.enumerablemap;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableMap;

public class Remove {
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		EnumerableMap<Integer, String> source = new EnumerableMap<>();
		source.put(1, "a");
		source.put(2, "b");
		source.put(3, "c");

		Assert.assertEquals("b", source.remove(2));
		Assert.assertEquals(null, source.remove("str"));
		Assert.assertEquals(2, source.size());
	}
}
