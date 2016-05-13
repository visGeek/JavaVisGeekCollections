package com.github.visgeek.utils.collections.test.testcase.set.iset;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableSet;

public class RemoveValue {
	@Test
	public void test() {
		EnumerableSet<Integer> set = new EnumerableSet<>();
		set.add(1);
		set.add(2);
		set.add(3);

		Assert.assertEquals(3, set.size());

		Assert.assertEquals(true, set.removeValue(1));
		Assert.assertEquals(true, set.removeValue(2));
		Assert.assertEquals(true, set.removeValue(3));
		Assert.assertEquals(false, set.removeValue(4));

		Assert.assertEquals(0, set.size());
	}
}
