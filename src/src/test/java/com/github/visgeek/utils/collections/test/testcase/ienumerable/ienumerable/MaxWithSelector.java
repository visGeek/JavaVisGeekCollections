package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Func1;
import com.github.visgeek.utils.testing.Assert2;
import com.github.visgeek.utils.testing.CollectionCreator;

public class MaxWithSelector {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void argIsNull() {
		Assert2.assertNullPointerExceptionThrown(this.expectedException, "selector");

		String[] source = new String[] {};
		Func1<String, Integer> selector = null;

		IEnumerable<String> enumerable = () -> CollectionCreator.iterator(source);
		enumerable.max(selector);
	}

	@Test
	public void empty() {
		String[] source = new String[] {};
		Func1<String, Integer> selector = str -> str == null ? null : Integer.parseInt(str);
		String expected = null;

		IEnumerable<String> enumerable = () -> CollectionCreator.iterator(source);
		Integer actual = enumerable.max(selector);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void normal() {
		String[] source = new String[] { "2", "1", null, "3" };
		Func1<String, Integer> selector = str -> str == null ? null : Integer.parseInt(str);
		Integer expected = 3;

		IEnumerable<String> enumerable = () -> CollectionCreator.iterator(source);
		Integer actual = enumerable.max(selector);
		Assert.assertEquals(expected, actual);
	}
}
