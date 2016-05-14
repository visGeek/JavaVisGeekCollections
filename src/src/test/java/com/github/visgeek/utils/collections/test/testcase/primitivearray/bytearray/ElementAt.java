package com.github.visgeek.utils.collections.test.testcase.primitivearray.bytearray;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IByteEnumerable;

public class ElementAt {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testSuccess() {
		byte[] source = new byte[] { 1, 2, 3 };
		int index = 1;
		byte expected = 2;

		IByteEnumerable enumerable = Enumerable.of(source);
		byte actual = enumerable.elementAt(index);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testIndexOutOfRange01() {
		this.expectedException.expect(IllegalArgumentException.class);

		byte[] source = new byte[] { 1, 2, 3 };
		int index = -1;

		IByteEnumerable enumerable = Enumerable.of(source);
		enumerable.elementAt(index);
	}

	@Test
	public void testIndexOutOfRange022() {
		this.expectedException.expect(IllegalArgumentException.class);

		byte[] source = new byte[] { 1, 2, 3 };
		int index = 4;

		IByteEnumerable enumerable = Enumerable.of(source);
		enumerable.elementAt(index);
	}
}
