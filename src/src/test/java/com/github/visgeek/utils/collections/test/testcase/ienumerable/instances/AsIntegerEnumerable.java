package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.IIntegerEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class AsIntegerEnumerable {
	@Test
	public void isIIntegerEnumerable() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		IIntegerEnumerable source2 = source.asIntegerEnumerable();
		source2.sum();
	}

	@Test
	public void isIntegerEnumerable() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		IIntegerEnumerable source2 = source.asIntegerEnumerable();
		source2.sum();
	}

	@Test
	public void noException() {
		IEnumerable<String> source = Enumerable.of("a", "b", "c");
		Action0 action = () -> source.asIntegerEnumerable();
		Assert2.assertExceptionNotThrown(action);
	}
}
