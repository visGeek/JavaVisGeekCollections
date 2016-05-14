package com.github.visgeek.utils.collections.test.testcase.collection.map.enumerablelinkedmap;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.EnumerableLinkedMap;

public class Clone {
	@Test
	public void test() {
		EnumerableLinkedMap<Integer, String> source = new EnumerableLinkedMap<>();
		Enumerable.range(0, 10000).forEach(n -> source.put(n, n.toString()));

		EnumerableLinkedMap<Integer, String> clone = source.clone();

		Assert.assertNotSame(source, clone);
		Assert.assertEquals(source.entrySet(), clone.entrySet());
	}
}
