package com.github.visgeek.utils.collections.test.testcase.ienumerable.statics;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Range01 {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void argErrorCountIsNegative() {
		this.expectedException.expect(IllegalArgumentException.class);
		Enumerable.range(0, -1);
	}

	@Test
	public void argErrorOverIntegerMax() {
		this.expectedException.expect(IllegalArgumentException.class);
		Enumerable.range(Integer.MAX_VALUE, 2);
	}

	@Test
	public void startIsNegative() {
		IEnumerable<Integer> actual = Enumerable.range(-3, 3);
		Assert2.assertSequanceEquals(actual, -3, -2, -1);
	}

	@Test
	public void startIsZero() {
		IEnumerable<Integer> actual = Enumerable.range(0, 3);
		Assert2.assertSequanceEquals(actual, 0, 1, 2);
	}

	@Test
	public void startIsPositive() {
		IEnumerable<Integer> actual = Enumerable.range(3, 3);
		Assert2.assertSequanceEquals(actual, 3, 4, 5);
	}

	@Test
	public void countIsZero() {
		IEnumerable<Integer> actual = Enumerable.range(1, 0);
		Assert2.assertSequanceEquals(actual);
	}
}
