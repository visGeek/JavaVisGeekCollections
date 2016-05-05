package com.github.visgeek.utils.collections.test.testcase.ienumerable.statics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Of {
	@Test
	public void array_empty() {
		Object[] values = new Object[] {};
		IEnumerable<Object> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void array_normal() {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		Object[] values = new Object[] { obj1, obj2, obj3 };
		IEnumerable<Object> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual, obj1, obj2, obj3);
	}

	@Test
	public void iterable_empty() {
		List<Object> values = Arrays.<Object> asList();
		IEnumerable<Object> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void iterable_normal() {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		List<Object> values = Arrays.asList(obj1, obj2, obj3);
		IEnumerable<Object> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual, obj1, obj2, obj3);
	}

	@Test
	public void stream_empty() {
		Stream<Object> values = Arrays.<Object> asList().stream();
		IEnumerable<Object> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void stream_normal() {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		Stream<Object> values = Arrays.asList(obj1, obj2, obj3).stream();;
		IEnumerable<Object> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual, obj1, obj2, obj3);
	}
}
