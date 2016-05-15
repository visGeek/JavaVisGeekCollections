package com.github.visgeek.utils.collections.test.testcase.readonlycollection;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class Constructor {
	@Test
	public void list() {
		Collection<Integer> source = CollectionCreator.collection(1, 2, 3);
		int index = 0;
		int expected = 1;

		IEnumerable<Integer> enumerable = Enumerable.of(source);
		int actual = enumerable.elementAt(index);
		Assert.assertEquals(expected, actual);
	}
}
