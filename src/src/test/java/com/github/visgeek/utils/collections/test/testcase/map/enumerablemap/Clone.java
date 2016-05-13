package com.github.visgeek.utils.collections.test.testcase.map.enumerablemap;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.EnumerableMap;

public class Clone {
	@Test
	public void test() {
		EnumerableMap<Integer, String> source = new EnumerableMap<>();
		Enumerable.range(0, 10000).forEach(n -> source.put(n, n.toString()));

		EnumerableMap<Integer, String> clone = source.clone();
		Assert.assertEquals(source.entrySet(), clone.entrySet());
	}
}
