package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class SingleOrDefault02 {
	@Test
	public void empty() {
		IEnumerable<Integer> source = () -> Enumerable.empty(Integer.class).iterator();
		Integer defaultValue = 0;
		Integer expected = defaultValue;

		Integer actual = source.singleOrDefault(defaultValue);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void towOrOrver() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2).iterator();
		Integer defaultValue = 0;
		Integer expected = defaultValue;

		Integer actual = source.singleOrDefault(defaultValue);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void success() {
		IEnumerable<Integer> source = () -> Enumerable.of(1).iterator();
		Integer defaultValue = 0;
		Integer expected = 1;

		Integer actual = source.singleOrDefault(defaultValue);
		Assert.assertEquals(expected, actual);
	}
}
