package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.IBooleanEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class IBooleanEnumerableTest {
	private final Boolean[] sourceFilled = new Boolean[] { null, false, true, true, true };

	@Test
	public void toPrimitiveArray() {
		boolean[] expected = CollectionCreator.primitiveArray(this.sourceFilled);

		IBooleanEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		boolean[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
