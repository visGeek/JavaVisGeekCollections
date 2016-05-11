package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.IEqualityComparator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Contains02 {
	// 等価比較子
	private final IEqualityComparator<String> comparator =
			IEqualityComparator.create(
					str -> Integer.parseInt(str),
					(a, b) -> Integer.parseInt(a) == Integer.parseInt(b));

	// テストケース
	@Test
	public void iterableContains_ComparatorIsNull() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		int target = 2;
		boolean expected = true;

		IEnumerable<Integer> values = () -> Enumerable.of(source).iterator();
		boolean actual = values.contains(target, null);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void iterableNotContains_ComparatorIsNull() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		int target = 4;
		boolean expected = false;

		IEnumerable<Integer> values = () -> Enumerable.of(source).iterator();
		boolean actual = values.contains(target, null);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void iterableContains() {
		String[] source = new String[] { "01", "02", "03" };
		String target = "2";
		boolean expected = true;

		IEnumerable<String> values = () -> Enumerable.of(source).iterator();
		boolean actual = values.contains(target, this.comparator);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void iterableNotContains() {
		String[] source = new String[] { "01", "02", "03" };
		String target = "4";
		boolean expected = false;

		IEnumerable<String> values = () ->Enumerable.of(source).iterator();
		boolean actual = values.contains(target, this.comparator);
		Assert.assertEquals(expected, actual);
	}
}
