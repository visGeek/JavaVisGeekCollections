package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class ToString01 {
	@Test
	public void empty() {
		IEnumerable<Integer> source = Enumerable.empty();
		String separator = "";
		String expected = "";

		String actual = source.toString(separator);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void separatorIsNull() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, null, 3, 4).iterator();
		String separator = null;
		String expected = "1234";

		String actual = source.toString(separator);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void nomal() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, null, 3, 4).iterator();
		String separator = ", ";
		String expected = "1, 2, , 3, 4";

		String actual = source.toString(separator);
		Assert.assertEquals(expected, actual);
	}
}
