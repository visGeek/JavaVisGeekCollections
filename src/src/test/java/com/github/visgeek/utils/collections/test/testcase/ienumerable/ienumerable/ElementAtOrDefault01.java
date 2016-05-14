package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.IEnumerable;

public class ElementAtOrDefault01 {
	@Test
	public void noDefaultValue_success() {
		IEnumerable<Integer> source = () -> Arrays.asList(1, 2, 3).iterator();
		int index = 1;
		Integer expected = 2;

		Integer actual = source.elementAtOrDefault(index);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void noDefaultValue_fail_01() {
		IEnumerable<Integer> source = () -> Arrays.asList(1, 2, 3).iterator();
		int index = -1;
		Integer expected = null;

		Integer actual = source.elementAtOrDefault(index);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void noDefaultValue_fail_02() {
		IEnumerable<Integer> source = () -> Arrays.asList(1, 2, 3).iterator();
		int index = 3;
		Integer expected = null;

		Integer actual = source.elementAtOrDefault(index);
		Assert.assertEquals(expected, actual);
	}
}
