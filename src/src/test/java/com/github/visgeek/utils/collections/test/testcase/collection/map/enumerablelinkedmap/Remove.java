package com.github.visgeek.utils.collections.test.testcase.collection.map.enumerablelinkedmap;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableLinkedMap;

public class Remove {
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		EnumerableLinkedMap<Integer, String> source = new EnumerableLinkedMap<>();
		source.put(1, "a");
		source.put(2, "b");
		source.put(3, "c");

		Assert.assertEquals("b", source.remove(2));
		Assert.assertEquals(null, source.remove("str"));
		Assert.assertEquals(2, source.size());
	}
}
