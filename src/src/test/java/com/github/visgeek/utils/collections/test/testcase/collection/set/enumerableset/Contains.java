package com.github.visgeek.utils.collections.test.testcase.collection.set.enumerableset;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableSet;

public class Contains {
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		EnumerableSet<Integer> source = new EnumerableSet<>();
		source.add(1);
		source.add(2);
		source.add(3);

		Assert.assertEquals(true, source.contains(1));
		Assert.assertEquals(true, source.contains(2));
		Assert.assertEquals(true, source.contains(3));
		Assert.assertEquals(false, source.contains(4));
	}
}
