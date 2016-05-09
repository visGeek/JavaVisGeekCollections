package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class FirstOrDefault04 {
	@Test
	public void empty() {
		IEnumerable<Integer> source = Enumerable.empty();
		Func1<Integer, Boolean> predicate = n -> n <= 2;
		Integer defaultValue = 0;
		Integer expected = defaultValue;

		Integer actual = source.firstOrDefault(predicate, defaultValue);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void found() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Func1<Integer, Boolean> predicate = n -> 2 <= n;
		Integer defaultValue = 0;
		Integer expected = 2;

		Integer actual = source.firstOrDefault(predicate, defaultValue);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notFound() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Func1<Integer, Boolean> predicate = n -> 4 <= n;
		Integer defaultValue = 0;
		Integer expected = defaultValue;

		Integer actual = source.firstOrDefault(predicate, defaultValue);
		Assert.assertEquals(expected, actual);
	}
}
