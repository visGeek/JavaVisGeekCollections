package com.github.visgeek.utils.collections.test.testcase.collection.set.iset;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableSet;

public class ContainsValue {
	@Test
	public void test() {
		EnumerableSet<Integer> set = new EnumerableSet<>();
		set.add(1);
		set.add(2);
		set.add(3);

		Assert.assertEquals(true, set.containsValue(1));
		Assert.assertEquals(true, set.containsValue(2));
		Assert.assertEquals(true, set.containsValue(3));
		Assert.assertEquals(false, set.containsValue(4));
	}
}
