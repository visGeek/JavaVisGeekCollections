package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.IEqualityComparator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Union02 {
	@Test
	public void secondIsNull() {
		IEnumerable<Integer> source = Enumerable.empty();
		IEnumerable<Integer> second = null;
		IEqualityComparator<Integer> comparator = IEqualityComparator.create(n -> n);

		Action0 action = () -> source.union(second, comparator);
		Assert2.assertNullPointerExceptionThrown("second", action);
	}

	@Test
	public void comparatorIsNull() {
		IEnumerable<Integer> source = Enumerable.empty();
		IEnumerable<Integer> second = Enumerable.empty();
		IEqualityComparator<Integer> comparator = null;

		Action0 action = () -> source.union(second, comparator);
		Assert2.assertExceptionNotThrown(action);
	}

	@Test
	public void test() {
		IEnumerable<String> source = () -> Enumerable.of("!1", "!1", "!2", "!2", "!3", "!3", "!4", "!4").iterator();
		IEnumerable<String> second = () -> Enumerable.of("#3", "#3", "#2", "#2", "#4", "#4", "#5", "#5").iterator();
		IEqualityComparator<String> comparator = IEqualityComparator.create(n -> n.substring(1));
		IEnumerable<String> expected = Enumerable.of("!1", "!2", "!3", "!4", "#5");

		IEnumerable<String> actual = source.union(second, comparator);
		Assert2.assertSequanceEquals(actual, expected);
	}
}
