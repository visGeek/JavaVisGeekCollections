package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.ILongEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class AsLongEnumerable {
	@Test
	public void isILongEnumerable() {
		IEnumerable<Long> source = Enumerable.of(1L, 2L, 3L);
		ILongEnumerable source2 = source.asLongEnumerable();
		source2.sum();
	}

	@Test
	public void isLongEnumerable() {
		IEnumerable<Long> source = Enumerable.of(1L, 2L, 3L);
		ILongEnumerable source2 = source.asLongEnumerable();
		source2.sum();
	}

	@Test
	public void noException() {
		IEnumerable<String> source = Enumerable.of("a", "b", "c");
		Action0 action = () -> source.asLongEnumerable();
		Assert2.assertExceptionNotThrown(action);
	}
}
