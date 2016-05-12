package com.github.visgeek.utils.collections.test.testcase.map.ireadonlymap;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableMap;

public class Count {
	@Test
	public void empty() {
		EnumerableMap<Integer, Integer> map = new EnumerableMap<>();
		Assert.assertEquals(0, map.count());
	}

	@Test
	public void any() {
		EnumerableMap<Integer, Integer> map = new EnumerableMap<>();
		map.put(0, 0);
		map.put(1, 1);
		map.put(2, 2);
		Assert.assertEquals(3, map.count());
	}
}
