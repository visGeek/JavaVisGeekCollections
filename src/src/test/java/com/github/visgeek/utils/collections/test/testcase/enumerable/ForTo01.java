package com.github.visgeek.utils.collections.test.testcase.enumerable;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ForTo01 {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void argError() {
		this.expectedException.expect(IllegalArgumentException.class);
		Enumerable.forTo(0, -1);
	}

	@Test
	public void same01() {
		IEnumerable<Integer> source = Enumerable.forTo(0, 0);
		Assert2.assertSequanceEquals(source, 0);
	}

	@Test
	public void same02() {
		IEnumerable<Integer> source = Enumerable.forTo(2, 2);
		Assert2.assertSequanceEquals(source, 2);
	}

	@Test
	public void iterationNegativeToNegative() {
		IEnumerable<Integer> source = Enumerable.forTo(-5, -3);
		Assert2.assertSequanceEquals(source, -5, -4, -3);
	}

	@Test
	public void iterationNegativeToZero() {
		IEnumerable<Integer> source = Enumerable.forTo(-5, 0);
		Assert2.assertSequanceEquals(source, -5, -4, -3, -2, -1, 0);
	}

	@Test
	public void iterationNegativeToPositive() {
		IEnumerable<Integer> source = Enumerable.forTo(-5, 5);
		Assert2.assertSequanceEquals(source, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
	}

	@Test
	public void iterationZeroToPositive() {
		IEnumerable<Integer> source = Enumerable.forTo(0, 5);
		Assert2.assertSequanceEquals(source, 0, 1, 2, 3, 4, 5);
	}

	@Test
	public void iterationPositiveToPositive() {
		IEnumerable<Integer> source = Enumerable.forTo(3, 5);
		Assert2.assertSequanceEquals(source, 3, 4, 5);
	}
}
