package com.github.visgeek.utils.collections.test.testcase.map.imap;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.testing.Assert2;

public class GetValueOrDefault01 {
	@Test
	public void test() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		Assert.assertEquals("a", map.getValueOrDefault(1, "_"));
		Assert.assertEquals("b", map.getValueOrDefault(2, "_"));
		Assert.assertEquals("c", map.getValueOrDefault(3, "_"));
		Assert.assertEquals("_", map.getValueOrDefault(4, "_"));
		Assert.assertEquals(null, map.getValueOrDefault(5, (String) null));

		// 新しいエントリーが登録されていない。
		Assert2.assertSequanceEquals(map.enumerateValues().orderByDefaultKey(), "a", "b", "c");
	}
}
