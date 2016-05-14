package com.github.visgeek.utils.collections.test.testcase.readonlylist;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Get {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void success() {
		IEnumerable<Integer> source = Enumerable.of(new Integer[] { 1, 2, 3 });
		int actual = source.elementAt(1); // elementAt() で確認する。
		Assert.assertEquals(2, actual);
	}

	@Test
	public void testIndexOutOfRange01() {
		this.expectedException.expect(IllegalArgumentException.class);

		IEnumerable<Integer> source = Enumerable.of(new Integer[] { 1, 2, 3 });
		source.elementAt(-1); // elementAt() で確認する。
	}

	@Test
	public void testIndexOutOfRange02() {
		this.expectedException.expect(IllegalArgumentException.class);

		IEnumerable<Integer> source = Enumerable.of(new Integer[] { 1, 2, 3 });
		source.elementAt(4); // elementAt() で確認する。
	}
}
