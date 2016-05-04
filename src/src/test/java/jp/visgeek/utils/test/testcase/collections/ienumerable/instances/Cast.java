package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import jp.visgeek.utils.collections.Enumerable;
import jp.visgeek.utils.collections.IEnumerable;
import jp.visgeek.utils.testing.Assert2;

public class Cast {
	@Test
	public void test_cast01() {
		try {
			IEnumerable<Object> objects = Enumerable.of("a", "b", "c");
			IEnumerable<String> strings = objects.cast(String.class);
			Assert2.assertSequanceEquals(strings, "a", "b", "c");

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void test_cast02() {
		try {
			IEnumerable<Object> objects = Enumerable.of("a", "b", "c");
			IEnumerable<String> strings = objects.cast();
			Assert2.assertSequanceEquals(strings, "a", "b", "c");

		} catch (Exception e) {
			Assert.fail();
		}
	}
}
