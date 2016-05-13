package com.github.visgeek.utils.collections.test.testcase.set.enumerablelinkedset;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableLinkedSet;

public class Remove {
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		EnumerableLinkedSet<Integer> source = new EnumerableLinkedSet<>();
		source.add(1);
		source.add(2);
		source.add(3);

		Assert.assertEquals(3, source.size());

		Assert.assertEquals(true, source.remove(1));
		Assert.assertEquals(true, source.remove(2));
		Assert.assertEquals(true, source.remove(3));
		Assert.assertEquals(false, source.remove(4));

		Assert.assertEquals(0, source.size());
	}
}
