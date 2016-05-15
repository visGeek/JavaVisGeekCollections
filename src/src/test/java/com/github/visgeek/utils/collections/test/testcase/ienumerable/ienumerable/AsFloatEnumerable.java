package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.IFloatEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class AsFloatEnumerable {
	@Test
	public void isIFloatEnumerable() {
		IEnumerable<Float> source = Enumerable.of(1.0f, 2.0f, 3.0f);
		IFloatEnumerable source2 = source.asFloatEnumerable();
		source2.sum();
	}

	@Test
	public void isFloatEnumerable() {
		IEnumerable<Float> source = () -> Enumerable.of(1.0f, 2.0f, 3.0f).iterator();
		IFloatEnumerable source2 = source.asFloatEnumerable();
		source2.sum();
	}

	@Test
	public void noException() {
		IEnumerable<String> source = Enumerable.of("a", "b", "c");
		Action0 action = () -> source.asFloatEnumerable();
		Assert2.assertExceptionNotThrown(action);
	}
}
