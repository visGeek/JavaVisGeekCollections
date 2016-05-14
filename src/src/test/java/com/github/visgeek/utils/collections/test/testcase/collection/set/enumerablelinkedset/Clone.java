package com.github.visgeek.utils.collections.test.testcase.collection.set.enumerablelinkedset;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableLinkedSet;

public class Clone {
	@Test
	public void test() {
		EnumerableLinkedSet<Integer> source = new EnumerableLinkedSet<>();
		source.add(1);
		source.add(2);
		source.add(3);

		EnumerableLinkedSet<Integer> clone = source.clone();

		Assert.assertNotSame(source, clone);
		Assert.assertEquals(source, clone);
	}
}
