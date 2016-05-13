package com.github.visgeek.utils.collections.test.testcase.set.enumerableset;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableSet;

public class Clone {
	@Test
	public void test() {
		EnumerableSet<Integer> source = new EnumerableSet<>();
		source.add(1);
		source.add(2);
		source.add(3);

		EnumerableSet<Integer> clone = source.clone();

		Assert.assertNotSame(source, clone);
		Assert.assertEquals(source, clone);
	}
}
