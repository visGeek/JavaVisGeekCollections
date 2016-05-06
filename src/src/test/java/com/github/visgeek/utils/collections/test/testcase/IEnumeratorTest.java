package com.github.visgeek.utils.collections.test.testcase;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.IEnumerator;
import com.github.visgeek.utils.testing.Assert2;

public class IEnumeratorTest {
	@Test
	public void test() {
		IEnumerator<Integer> e = IEnumerator.create(() -> 0, val -> val <= 5, val -> val + 1);

		Assert.assertTrue(e.moveNext());
		Assert.assertEquals(e.current(), Integer.valueOf(0));

		Assert.assertTrue(e.moveNext());
		Assert.assertEquals(e.current(), Integer.valueOf(1));

		IEnumerable<Integer> values = e.toEnumerableRemaining();

		Assert2.assertSequanceEquals(values, 2, 3, 4, 5);
	}
}
