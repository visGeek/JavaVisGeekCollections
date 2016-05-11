package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.ilistenumerable;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Single01 {
	@Test
	public void empty() {
		IEnumerable<Integer> source = Enumerable.of(Arrays.asList());
		Action0 action = () -> source.single();
		Assert2.assertExceptionThrown(UnsupportedOperationException.class, action);
	}

	@Test
	public void towOrOrver() {
		IEnumerable<Integer> source = Enumerable.of(1, 2);
		Action0 action = () -> source.single();
		Assert2.assertExceptionThrown(UnsupportedOperationException.class, action);
	}

	@Test
	public void success() {
		IEnumerable<Integer> source = Enumerable.of(1);
		int expected = 1;

		int actual = source.single();
		Assert.assertEquals(expected, actual);
	}
}
