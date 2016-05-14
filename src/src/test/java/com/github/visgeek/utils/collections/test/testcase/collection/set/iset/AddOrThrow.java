package com.github.visgeek.utils.collections.test.testcase.collection.set.iset;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableSet;

public class AddOrThrow {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void test() {
		EnumerableSet<Integer> set = new EnumerableSet<>();
		set.addOrThrow(0);
		Assert.assertEquals(1, set.size());
		Assert.assertEquals(true, set.containsValue(0));

		set.addOrThrow(1);
		Assert.assertEquals(2, set.size());
		Assert.assertEquals(true, set.containsValue(1));

		this.expectedException.expect(IllegalArgumentException.class);
		set.addOrThrow(1);
	}
}
