package com.github.visgeek.utils.collections.test.testcase.ireadonlylist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class ElementAtOrDefault02 {
	@Test
	public void defaultValueExists_success() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		int index = 1;
		Integer defaultValue = 0;
		Integer expected = 2;

		Integer actual = source.elementAtOrDefault(index, defaultValue);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void defaultValueExists_fail_01() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		int index = -1;
		Integer defaultValue = 0;
		Integer expected = defaultValue;

		Integer actual = source.elementAtOrDefault(index, defaultValue);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void defaultValueExists_fail_02() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		int index = 3;
		Integer defaultValue = 0;
		Integer expected = defaultValue;

		Integer actual = source.elementAtOrDefault(index, defaultValue);
		Assert.assertEquals(expected, actual);
	}
}
