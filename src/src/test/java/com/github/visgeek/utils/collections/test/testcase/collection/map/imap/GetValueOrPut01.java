package com.github.visgeek.utils.collections.test.testcase.collection.map.imap;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableMap;

public class GetValueOrPut01 {
	@Test
	public void withoutLock() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		Assert.assertEquals("a", map.getValueOrPut(1, "_"));
		Assert.assertEquals("b", map.getValueOrPut(2, "_"));
		Assert.assertEquals("c", map.getValueOrPut(3, "_"));
		Assert.assertEquals("_", map.getValueOrPut(4, "_"));
		Assert.assertEquals(null, map.getValueOrPut(5, (String) null));

		// 新しいエントリーが登録されている。
		Assert.assertEquals("_", map.getValue(4));
		Assert.assertEquals(null, map.getValue(5));
	}

	@Test
	public void withLock() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		Object lockObjectOrNull = new Object();
		Assert.assertEquals("a", map.getValueOrPut(1, "_", lockObjectOrNull));
		Assert.assertEquals("b", map.getValueOrPut(2, "_", lockObjectOrNull));
		Assert.assertEquals("c", map.getValueOrPut(3, "_", lockObjectOrNull));
		Assert.assertEquals("_", map.getValueOrPut(4, "_", lockObjectOrNull));
		Assert.assertEquals(null, map.getValueOrPut(5, (String) null, lockObjectOrNull));

		// 新しいエントリーが登録されている。
		Assert.assertEquals("_", map.getValue(4));
		Assert.assertEquals(null, map.getValue(5));
	}
}
