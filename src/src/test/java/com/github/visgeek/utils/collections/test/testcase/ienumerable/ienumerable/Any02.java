package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.functions.Predicate;
import com.github.visgeek.utils.testing.Assert2;

public class Any02 {
	@Test
	public void caseArgIsNull() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Action0 action = () -> source.any(null);
		Assert2.assertNullPointerExceptionThrown("predicate", action);
	}

	@Test
	public void caseTrue() {
		this.test(true, n -> n == 2, 1, 2, 3);
	}

	@Test
	public void caseFalse() {
		this.test(false, n -> n == 4, 1, 2, 3);
	}

	public void test(boolean expected, Predicate<Integer> predicate, Integer... sourceArray) {
		IEnumerable<Integer> source = () -> Enumerable.of(sourceArray).iterator();
		boolean actual = source.any(predicate);
		Assert.assertEquals(expected, actual);
	}
}
