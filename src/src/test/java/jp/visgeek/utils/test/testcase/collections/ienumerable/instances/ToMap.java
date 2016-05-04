package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import jp.visgeek.utils.collections.Enumerable;
import jp.visgeek.utils.collections.EnumerableMap;

public class ToMap {
	@Test
	public void test_toMap01() {
		EnumerableMap<Integer, Integer> actual = Enumerable.ofInteger(1, 2, 3).toMap(n -> n);
		Assert.assertEquals(3, actual.size());
		Assert.assertEquals(1, (int) actual.getValue(1));
		Assert.assertEquals(2, (int) actual.getValue(2));
		Assert.assertEquals(3, (int) actual.getValue(3));
	}

	@Test
	public void test_toMap02() {
		EnumerableMap<Integer, Integer> actual = Enumerable.ofInteger(1, 2, 3).toMap((n, idx) -> idx);
		Assert.assertEquals(3, actual.size());
		Assert.assertEquals(1, (int) actual.getValue(0));
		Assert.assertEquals(2, (int) actual.getValue(1));
		Assert.assertEquals(3, (int) actual.getValue(2));
	}

	@Test
	public void test_toMap03() {
		try {
			Enumerable.ofInteger(1, 1, 3).toMap(n -> n);
			Assert.fail();
		} catch (IllegalArgumentException ex) {
			//
		}
	}
}
