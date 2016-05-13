package com.github.visgeek.utils.collections.test.testcase.map.enumerablelinkedmap;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableLinkedMap;

public class GetOrDefault {
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		EnumerableLinkedMap<Integer, String> source = new EnumerableLinkedMap<>();
		source.put(1, "a");
		source.put(2, "b");
		source.put(3, "c");

		Assert.assertEquals("b", source.getOrDefault(2, "_"));
		Assert.assertEquals("_", source.getOrDefault("str", "_"));
	}
}