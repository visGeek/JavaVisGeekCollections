package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class AsStream {
	@Test
	public void case01() {
		IEnumerable<Integer> source = ()->Enumerable.of(1, 2, 3).iterator();
		Action0 action = () -> ((IEnumerable<Integer>) () -> source.asStream().iterator()).any();
		Assert2.assertExceptionNotThrown(action);
	}
}
