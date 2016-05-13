package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.IEqualityComparator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class SequenceEqual02 {
	@Test
	public void arg1IsNull() {
		IEnumerable<Integer> source1 = Enumerable.empty();
		IEnumerable<Integer> source2 = null;
		IEqualityComparator<Integer> comparator = IEqualityComparator.create(n -> n);

		Action0 action = () -> source1.sequenceEqual(source2, comparator);
		Assert2.assertNullPointerExceptionThrown("second", action);
	}

	@Test
	public void arg2IsNull() {
		IEnumerable<Integer> source1 = Enumerable.empty();
		IEnumerable<Integer> source2 = Enumerable.empty();
		IEqualityComparator<Integer> comparator = null;

		Action0 action = () -> source1.sequenceEqual(source2, comparator);
		Assert2.assertExceptionNotThrown(action);
	}

	@Test
	public void equalEmpty() {
		IEnumerable<String> source1 = Enumerable.empty();
		IEnumerable<String> source2 = Enumerable.empty();
		IEqualityComparator<String> comparator = IEqualityComparator.create(str -> str.substring(1));

		boolean actual = source1.sequenceEqual(source2, comparator);
		Assert.assertTrue(actual);
	}

	@Test
	public void equalFill() {
		IEnumerable<String> source1 = Enumerable.of("$1", "#2", "!3", "&4");
		IEnumerable<String> source2 = Enumerable.of("'1", "!2", "#3", "$4");
		IEqualityComparator<String> comparator = IEqualityComparator.create(str -> str.substring(1));

		boolean actual = source1.sequenceEqual(source2, comparator);
		Assert.assertTrue(actual);
	}

	@Test
	public void CountsNotEqual01() {
		IEnumerable<String> source1 = Enumerable.of("$1", "#2", "!3");
		IEnumerable<String> source2 = Enumerable.of("'1", "!2", "#3", "$4");
		IEqualityComparator<String> comparator = IEqualityComparator.create(str -> str.substring(1));

		boolean actual = source1.sequenceEqual(source2, comparator);
		Assert.assertFalse(actual);
	}

	@Test
	public void CountsNotEqual02() {
		IEnumerable<String> source1 = Enumerable.of("$1", "#2", "!3", "&4");
		IEnumerable<String> source2 = Enumerable.of("'1", "!2", "#3");
		IEqualityComparator<String> comparator = IEqualityComparator.create(str -> str.substring(1));

		boolean actual = source1.sequenceEqual(source2, comparator);
		Assert.assertFalse(actual);
	}

	@Test
	public void valuesNotEqual() {
		IEnumerable<String> source1 = Enumerable.of("!1", "#2", "$0");
		IEnumerable<String> source2 = Enumerable.of("#1", "!2", "$3");
		IEqualityComparator<String> comparator = IEqualityComparator.create(str -> str.substring(1));

		boolean actual = source1.sequenceEqual(source2, comparator);
		Assert.assertFalse(actual);
	}
}
