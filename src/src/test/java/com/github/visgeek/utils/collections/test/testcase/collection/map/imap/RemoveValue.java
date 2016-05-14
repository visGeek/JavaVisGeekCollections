package com.github.visgeek.utils.collections.test.testcase.collection.map.imap;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableMap;

public class RemoveValue {
	@Test
	public void test() {
		EnumerableMap<Integer, String> enumerableMap = new EnumerableMap<>();
		enumerableMap.put(1, "a");
		enumerableMap.put(2, "b");
		enumerableMap.put(3, "c");

		HashMap<Integer, String> hashMap = new HashMap<>();
		hashMap.put(1, "a");
		hashMap.put(2, "b");
		hashMap.put(3, "c");

		Assert.assertEquals(hashMap.remove(1), enumerableMap.removeValue(1));
		Assert.assertEquals(hashMap.remove(2), enumerableMap.removeValue(2));
		Assert.assertEquals(hashMap.remove(3), enumerableMap.removeValue(3));

		Assert.assertEquals(0, enumerableMap.size());

		Assert.assertEquals(hashMap.remove(4), enumerableMap.removeValue(4));
	}
}
