package com.github.visgeek.utils.collections.test.testcase.primitivearray;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IBooleanEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.testing.Assert2;
import com.github.visgeek.utils.testing.CollectionCreator;

public class BooleanArrayTest {
	private final boolean[] sourceForContains = new boolean[] { true };

	private final boolean[] source = new boolean[] { false, true, true };

	private final IBooleanEnumerable enumerable = Enumerable.of(this.source);

	boolean containsParameter1 = true;

	boolean containsParameter2 = false;

	boolean elementAtExpected = true;

	@Test
	public void contains() {
		this.containsInternal(this.containsParameter1, true);
		this.containsInternal(this.containsParameter2, false);
		this.containsInternal(null, false);
	}

	public void containsInternal(Boolean target, boolean expected) {
		boolean actual = Enumerable.of(this.sourceForContains).contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void count() {
		int expected = 3;
		int actual = this.enumerable.count();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void elementAt() {
		boolean actual = this.enumerable.elementAt(1);
		Assert.assertEquals(this.elementAtExpected, actual);

		Action0 action1 = () -> this.enumerable.elementAt(-1);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action1);

		Action0 action2 = () -> this.enumerable.elementAt(4);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action2);
	}

	@Test
	public void iterator() {
		Assert2.assertSequanceEquals(this.enumerable, CollectionCreator.objectArray(this.source));
	}

	@Test
	public void toPrimitiveArray() {
		boolean[] actual = this.enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(this.source, actual);
	}
}
