package com.github.visgeek.utils.collections.test.testcase.map.imap;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableMap;

public class RemoveValueOrDefault01 {
	@Test
	public void defalutValue() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		Assert.assertEquals("_", map.removeValueOrDefault(4, "_"));
		Assert.assertEquals(null, map.removeValueOrDefault(4, (String) null));
		Assert.assertEquals(3, map.size());

		Assert.assertEquals("a", map.removeValueOrDefault(1, "_"));
		Assert.assertEquals("b", map.removeValueOrDefault(2, "_"));
		Assert.assertEquals("c", map.removeValueOrDefault(3, "_"));
		Assert.assertEquals(0, map.size());

		Assert.assertEquals("_", map.removeValueOrDefault(4, "_"));
		Assert.assertEquals(null, map.removeValueOrDefault(4, (String) null));
		Assert.assertEquals(0, map.size());
	}
}
