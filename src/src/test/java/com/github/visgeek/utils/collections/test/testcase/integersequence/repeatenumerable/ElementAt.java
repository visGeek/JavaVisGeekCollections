package com.github.visgeek.utils.collections.test.testcase.integersequence.repeatenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.testing.Assert2;

public class ElementAt {
	@Test
	public void test01() {
		IEnumerable<String> source = Enumerable.repeat2("a", 3);
		String actual = source.elementAt(1);
		Assert.assertEquals("a", actual);
	}

	@Test
	public void testIndexOutOfRange01() {
		IEnumerable<String> source = Enumerable.repeat2("a", 3);
		Action0 action = () -> source.elementAt(-1);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	@Test
	public void testIndexOutOfRange02() {
		IEnumerable<String> source = Enumerable.repeat2("a", 3);
		Action0 action = () -> source.elementAt(4);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}
}
