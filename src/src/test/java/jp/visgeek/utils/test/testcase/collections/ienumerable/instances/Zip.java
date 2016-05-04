package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Test;

import jp.visgeek.utils.Func2;
import jp.visgeek.utils.collections.Enumerable;
import jp.visgeek.utils.collections.IEnumerable;
import jp.visgeek.utils.testing.Assert2;

public class Zip {
	@Test
	public void test_zip01() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3);
		IEnumerable<String> values2 = Enumerable.of("one", "two", "three", "four");
		Func2<Integer, String, String> resultSelector = (a1, a2) -> String.format("%d - %s", a1, a2);

		IEnumerable<String> actual = values1.zip(values2, resultSelector);
		Assert2.assertSequanceEquals(actual, "1 - one", "2 - two", "3 - three");
	}

	@Test
	public void test_zip02() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3, 4);
		IEnumerable<String> values2 = Enumerable.of("one", "two", "three");
		Func2<Integer, String, String> resultSelector = (a1, a2) -> String.format("%d - %s", a1, a2);

		IEnumerable<String> actual = values1.zip(values2, resultSelector);
		Assert2.assertSequanceEquals(actual, "1 - one", "2 - two", "3 - three");
	}
}