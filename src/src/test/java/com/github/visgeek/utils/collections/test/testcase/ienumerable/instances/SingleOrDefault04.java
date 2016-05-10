package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class SingleOrDefault04 {
	@Test
	public void argIsNull() {
		IEnumerable<Integer> source = Enumerable.empty(Integer.class);
		Integer defaultValue = 0;
		Func1<Integer, Boolean> predicate = null;

		Action0 action = () -> source.singleOrDefault(predicate, defaultValue);
		Assert2.assertNullPointerExceptionThrown("predicate", action);
	}

	@Test
	public void notFound() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 3, 4).iterator();
		Func1<Integer, Boolean> predicate = n -> n == 2;
		Integer defaultValue = 0;
		Integer expected = defaultValue;

		Integer actual = source.singleOrDefault(predicate, defaultValue);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void towOrOrver() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 2, 3, 4).iterator();
		Func1<Integer, Boolean> predicate = n -> n == 2;
		Integer defaultValue = 0;
		Integer expected = defaultValue;

		Integer actual = source.singleOrDefault(predicate, defaultValue);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void success() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4).iterator();
		Func1<Integer, Boolean> predicate = n -> n == 2;
		Integer defaultValue = 0;
		Integer expected = 2;

		Integer actual = source.singleOrDefault(predicate, defaultValue);
		Assert.assertEquals(expected, actual);
	}
}
