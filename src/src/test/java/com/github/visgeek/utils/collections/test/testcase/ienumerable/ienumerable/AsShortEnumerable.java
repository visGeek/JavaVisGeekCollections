package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.IShortEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.testing.Assert2;

public class AsShortEnumerable {
	@Test
	public void isIShortEnumerable() {
		IEnumerable<Short> source = Enumerable.of((short) 1, (short) 2, (short) 3);
		IShortEnumerable source2 = source.asShortEnumerable();
		source2.sum();
	}

	@Test
	public void isShortEnumerable() {
		IEnumerable<Short> source = () -> Enumerable.of((short) 1, (short) 2, (short) 3).iterator();
		IShortEnumerable source2 = source.asShortEnumerable();
		source2.sum();
	}

	@Test
	public void noException() {
		IEnumerable<String> source = Enumerable.of("a", "b", "c");
		Action0 action = () -> source.asShortEnumerable();
		Assert2.assertExceptionNotThrown(action);
	}
}
