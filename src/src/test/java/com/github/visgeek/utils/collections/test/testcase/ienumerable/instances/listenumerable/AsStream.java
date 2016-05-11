package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.listenumerable;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class AsStream {
	@Test
	public void case01() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		IEnumerable<Integer> items = () -> source.asStream().iterator();
		Assert2.assertSequanceEquals(items, 1, 2, 3);
	}
}
