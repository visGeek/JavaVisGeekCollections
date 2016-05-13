package com.github.visgeek.utils.collections.test.testcase.ilistenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class ElementAtOrDefault01 {
	@Test
	public void noDefaultValue_success() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		int index = 1;
		Integer expected = 2;

		Integer actual = source.elementAtOrDefault(index);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void noDefaultValue_fail_01() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		int index = -1;
		Integer expected = null;

		Integer actual = source.elementAtOrDefault(index);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void noDefaultValue_fail_02() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		int index = 3;
		Integer expected = null;

		Integer actual = source.elementAtOrDefault(index);
		Assert.assertEquals(expected, actual);
	}
}
