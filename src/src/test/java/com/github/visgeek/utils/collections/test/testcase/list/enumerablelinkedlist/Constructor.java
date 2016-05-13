package com.github.visgeek.utils.collections.test.testcase.list.enumerablelinkedlist;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableLinkedList;
import com.github.visgeek.utils.testing.Assert2;

public class Constructor {
	@Test
	public void noArgs() {
		EnumerableLinkedList<Integer> actual = new EnumerableLinkedList<>(1, 2, 3);
		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void collection() {
		Collection<Integer> values = Arrays.asList(1, 2, 3);
		EnumerableLinkedList<Integer> actual = new EnumerableLinkedList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void iterable_Collection() {
		Iterable<Integer> values = Arrays.asList(1, 2, 3);
		EnumerableLinkedList<Integer> actual = new EnumerableLinkedList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void iterable_Iterable() {
		Iterable<Integer> values = () -> Arrays.asList(1, 2, 3).iterator();
		EnumerableLinkedList<Integer> actual = new EnumerableLinkedList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void array() {
		Integer[] values = new Integer[] { 1, 2, 3 };
		EnumerableLinkedList<Integer> actual = new EnumerableLinkedList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}
}
