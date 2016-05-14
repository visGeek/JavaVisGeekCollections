package com.github.visgeek.utils.collections.test.testcase.collection.map.imap;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableMap;

public class PutOrThrow {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void test() {
		EnumerableMap<Integer, String> enumerableMap = new EnumerableMap<>();
		HashMap<Integer, String> hashMap = new HashMap<>();

		Assert.assertEquals(hashMap.put(1, "a"), enumerableMap.putOrThrow(1, "a"));
		Assert.assertEquals(hashMap.put(2, "b"), enumerableMap.putOrThrow(2, "b"));
		Assert.assertEquals(hashMap.put(3, "c"), enumerableMap.putOrThrow(3, "c"));

		this.expectedException.expect(IllegalArgumentException.class);
		enumerableMap.putOrThrow(1, "a");
	}
}
