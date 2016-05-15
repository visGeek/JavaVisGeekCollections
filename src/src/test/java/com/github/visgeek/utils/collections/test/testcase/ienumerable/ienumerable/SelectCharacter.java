package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.functions.Func1;
import com.github.visgeek.utils.testing.Assert2;

public class SelectCharacter {
	@Test
	public void argIsNull() {
		IEnumerable<String> source = () -> Enumerable.empty(String.class).iterator();
		Func1<String, Character> selector = null;

		Action0 action = () -> source.selectCharacter(selector);
		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void test() {
		IEnumerable<String> source = () -> Enumerable.of("a", "b", "c").iterator();
		Func1<String, Character> selector = str -> str.charAt(0);
		IEnumerable<Character> expected = Enumerable.of('a', 'b', 'c');

		IEnumerable<Character> actual = source.selectCharacter(selector);
		Assert2.assertSequanceEquals(actual, expected);
	}
}
