package com.github.visgeek.utils.collections.test.testcase.ienumerable.statics;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.IndexedFunc0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ForTo02 {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	private final IndexedFunc0<String> selector = idx -> Integer.toString(idx);

	@Test
	public void argErrorInvalidRange() {
		this.expectedException.expect(IllegalArgumentException.class);
		Enumerable.forTo(0, -1, this.selector);
	}

	@Test
	public void argErrorSelectorIsNull() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("selector");

		Enumerable.forTo(0, 1, null);
	}

	@Test
	public void same01() {
		IEnumerable<String> source = Enumerable.forTo(0, 0, this.selector);
		Assert2.assertSequanceEquals(source, "0");
	}

	@Test
	public void same02() {
		IEnumerable<String> source = Enumerable.forTo(2, 2, this.selector);
		Assert2.assertSequanceEquals(source, "2");
	}

	@Test
	public void iterationNegativeToNegative() {
		IEnumerable<String> source = Enumerable.forTo(-5, -3, this.selector);
		Assert2.assertSequanceEquals(source, "-5", "-4", "-3");
	}

	@Test
	public void iterationNegativeToZero() {
		IEnumerable<String> source = Enumerable.forTo(-5, 0, this.selector);
		Assert2.assertSequanceEquals(source, "-5", "-4", "-3", "-2", "-1", "0");
	}

	@Test
	public void iterationNegativeToPositive() {
		IEnumerable<String> source = Enumerable.forTo(-5, 5, this.selector);
		Assert2.assertSequanceEquals(source, "-5", "-4", "-3", "-2", "-1", "0", "1", "2", "3", "4", "5");
	}

	@Test
	public void iterationZeroToPositive() {
		IEnumerable<String> source = Enumerable.forTo(0, 5, this.selector);
		Assert2.assertSequanceEquals(source, "0", "1", "2", "3", "4", "5");
	}

	@Test
	public void iterationPositiveToPositive() {
		IEnumerable<String> source = Enumerable.forTo(3, 5, this.selector);
		Assert2.assertSequanceEquals(source, "3", "4", "5");
	}
}
