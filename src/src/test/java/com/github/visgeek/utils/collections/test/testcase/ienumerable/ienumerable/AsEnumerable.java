package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class AsEnumerable {
	@Test
	public void case01() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		Action0 action = () -> source.asEnumerable();
		Assert2.assertExceptionNotThrown(action);
	}
}
