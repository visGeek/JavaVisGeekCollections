package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class SequenceEqual01 {
	@Test
	public void argIsNull() {
		IEnumerable<Integer> source1 = Enumerable.empty();
		IEnumerable<Integer> source2 = null;

		Action0 action = () -> source1.sequenceEqual(source2);
		Assert2.assertNullPointerExceptionThrown("second", action);
	}

	@Test
	public void equalEmpty() {
		IEnumerable<Integer> source1 = Enumerable.empty();
		IEnumerable<Integer> source2 = Enumerable.empty();
		boolean actual = source1.sequenceEqual(source2);
		Assert.assertTrue(actual);
	}

	@Test
	public void equalFill() {
		IEnumerable<Integer> source1 = Enumerable.of(1, 2, 3, 4);
		IEnumerable<Integer> source2 = Enumerable.of(1, 2, 3, 4);
		boolean actual = source1.sequenceEqual(source2);
		Assert.assertTrue(actual);
	}

	@Test
	public void CountsNotEqual01() {
		IEnumerable<Integer> source1 = Enumerable.of(1, 2, 3);
		IEnumerable<Integer> source2 = Enumerable.of(1, 2, 3, 4);
		boolean actual = source1.sequenceEqual(source2);
		Assert.assertFalse(actual);
	}

	@Test
	public void CountsNotEqual02() {
		IEnumerable<Integer> source1 = Enumerable.of(1, 2, 3, 4);
		IEnumerable<Integer> source2 = Enumerable.of(1, 2, 3);
		boolean actual = source1.sequenceEqual(source2);
		Assert.assertFalse(actual);
	}

	@Test
	public void valuesNotEqual() {
		IEnumerable<Integer> source1 = Enumerable.of(1, 2, 0);
		IEnumerable<Integer> source2 = Enumerable.of(1, 2, 3);
		boolean actual = source1.sequenceEqual(source2);
		Assert.assertFalse(actual);
	}
}
