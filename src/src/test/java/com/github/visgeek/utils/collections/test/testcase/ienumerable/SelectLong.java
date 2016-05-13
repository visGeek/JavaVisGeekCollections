package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class SelectLong {
	@Test
	public void argIsNull() {
		IEnumerable<String> source = () -> Enumerable.empty(String.class).iterator();
		Func1<String, Long> selector = null;

		Action0 action = () -> source.selectLong(selector);
		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void test() {
		IEnumerable<String> source = () -> Enumerable.of("1", "2", "3").iterator();
		Func1<String, Long> selector = str -> Long.parseLong(str);
		IEnumerable<Long> expected = Enumerable.of(1L, 2L, 3L);

		IEnumerable<Long> actual = source.selectLong(selector);
		Assert2.assertSequanceEquals(actual, expected);
	}
}
