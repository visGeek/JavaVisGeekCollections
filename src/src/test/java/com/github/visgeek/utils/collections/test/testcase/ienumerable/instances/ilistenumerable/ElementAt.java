package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.ilistenumerable;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ElementAt {
	@Test
	public void test01() {
		IEnumerable<Integer> source = Enumerable.of(Arrays.asList(1, 2, 3));
		int actual = source.elementAt(1);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void testIndexOutOfRange01() {
		IEnumerable<Integer> source = Enumerable.of(Arrays.asList(1, 2, 3));
		Action0 action = () -> source.elementAt(-1);
		Assert2.assertExceptionThrown(IndexOutOfBoundsException.class, action);
	}

	@Test
	public void testIndexOutOfRange02() {
		IEnumerable<Integer> source = Enumerable.of(Arrays.asList(1, 2, 3));
		Action0 action = () -> source.elementAt(4);
		Assert2.assertExceptionThrown(IndexOutOfBoundsException.class, action);
	}
}