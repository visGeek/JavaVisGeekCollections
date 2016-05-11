package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func2;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Zip01 {
	@Test
	public void secondIsNull() {
		IEnumerable<Integer> source = Enumerable.empty();
		IEnumerable<String> second = null;
		Func2<Integer, String, String> resultSelector = (a1, a2) -> String.format("%d - %s", a1, a2);

		Action0 action = () -> source.zip(second, resultSelector);
		Assert2.assertNullPointerExceptionThrown("second", action);
	}

	@Test
	public void test01() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		IEnumerable<String> second = () -> Enumerable.of("one", "two", "three", "four").iterator();
		Func2<Integer, String, String> resultSelector = (a1, a2) -> String.format("%d - %s", a1, a2);

		IEnumerable<String> actual = source.zip(second, resultSelector);
		Assert2.assertSequanceEquals(actual, "1 - one", "2 - two", "3 - three");
	}

	@Test
	public void test02() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3, 4).iterator();
		IEnumerable<String> second = () -> Enumerable.of("one", "two", "three").iterator();
		Func2<Integer, String, String> resultSelector = (a1, a2) -> String.format("%d - %s", a1, a2);

		IEnumerable<String> actual = source.zip(second, resultSelector);
		Assert2.assertSequanceEquals(actual, "1 - one", "2 - two", "3 - three");
	}
}
