package com.github.visgeek.utils.collections.test.testcase.map.imap;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableMap;

public class RemoveValueOrThrow {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

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

		Assert.assertEquals(hashMap.remove(1), enumerableMap.removeValueOrThrow(1));
		Assert.assertEquals(hashMap.remove(2), enumerableMap.removeValueOrThrow(2));
		Assert.assertEquals(hashMap.remove(3), enumerableMap.removeValueOrThrow(3));

		Assert.assertEquals(0, enumerableMap.size());

		this.expectedException.expect(IllegalArgumentException.class);
		enumerableMap.removeValueOrThrow(1);
	}
}
