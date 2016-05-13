package com.github.visgeek.utils.collections.test.testcase.list.ireadonlylist;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableList;

public class ElementAt {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testSuccess() {
		EnumerableList<Integer> source = new EnumerableList<>();
		source.add(1);
		source.add(2);
		source.add(3);

		int actual = source.elementAt(1);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void testIndexOutOfRange01() {
		this.expectedException.expect(IllegalArgumentException.class);

		EnumerableList<Integer> source = new EnumerableList<>();
		source.add(1);
		source.add(2);
		source.add(3);

		source.elementAt(-1);
	}

	@Test
	public void testIndexOutOfRange02() {
		this.expectedException.expect(IllegalArgumentException.class);

		EnumerableList<Integer> source = new EnumerableList<>();
		source.add(1);
		source.add(2);
		source.add(3);

		source.elementAt(4);
	}
}
