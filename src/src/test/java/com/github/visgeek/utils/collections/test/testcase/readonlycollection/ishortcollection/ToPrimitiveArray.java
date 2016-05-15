package com.github.visgeek.utils.collections.test.testcase.readonlycollection.ishortcollection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IShortEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		Short[] source = new Short[] { null, 1, 2, 3 };
		short[] expected = new short[] { 0, 1, 2, 3 };

		IShortEnumerable enumerable = Enumerable.of(source);
		short[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
