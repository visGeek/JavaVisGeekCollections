package com.github.visgeek.utils.collections.test.testcase.set.iset;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableSet;

public class AddAll {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void argIsNull() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("collection");

		EnumerableSet<Integer> set = new EnumerableSet<>();
		set.addAll((Iterable<Integer>) null);
	}

	@Test
	public void argAsCollection() {
		Iterable<Integer> values = Arrays.asList(1, 2, 3, 2); // Collection

		EnumerableSet<Integer> set = new EnumerableSet<>();
		set.addAll(values);
		Assert.assertEquals(3, set.size());
	}

	@Test
	public void argAsIterable() {
		Iterable<Integer> values = () -> Arrays.asList(1, 2, 3, 2).iterator(); // Iterable

		EnumerableSet<Integer> set = new EnumerableSet<>();
		set.addAll(values);
		Assert.assertEquals(3, set.size());
	}
}
