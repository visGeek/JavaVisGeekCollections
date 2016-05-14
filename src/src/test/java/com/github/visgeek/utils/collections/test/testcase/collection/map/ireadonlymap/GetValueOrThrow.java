package com.github.visgeek.utils.collections.test.testcase.collection.map.ireadonlymap;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableMap;

public class GetValueOrThrow {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void keyNotExists() {
		this.expectedException.expect(IllegalArgumentException.class);

		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "1");
		map.put(2, "2");
		map.put(3, "3");

		map.getValueOrThrow(4);
	}

	@Test
	public void keyExists() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "1");
		map.put(2, "2");
		map.put(3, "3");

		String actual = map.getValueOrThrow(2);
		Assert.assertEquals("2", actual);
	}
}
