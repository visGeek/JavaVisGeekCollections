package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.IEqualityComparator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Contains {
	public Contains() {
		// Contains メソッドでは hashCode を使わないのでカバレッジのために使っておく。
		this.getHashCode("0");
	}

	// 等価比較子
	private final IEqualityComparator<String> comparator =
			IEqualityComparator.create(
					this::getHashCode,
					(a, b) -> Integer.parseInt(a) == Integer.parseInt(b));

	// 使われないメソッド
	private int getHashCode(String str) {
		return Integer.parseInt(str);
	}

	// テストケース
	@Test
	public void test_contains01_01() {
		IEnumerable<Integer> values = Enumerable.of(1, 2, 3);
		boolean actual = values.contains(2);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_contains01_02() {
		IEnumerable<Integer> values = Enumerable.of(1, 2, 3);
		boolean actual = values.contains(4);
		Assert.assertFalse(actual);
	}

	@Test
	public void test_contains01_03() {
		Collection<Integer> values = Enumerable.of(1, 2, 3).toList();
		boolean actual = values.contains(2);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_contains01_04() {
		Collection<Integer> values = Enumerable.of(1, 2, 3).toList();
		boolean actual = values.contains(4);
		Assert.assertFalse(actual);
	}

	@Test
	public void test_contains02_01() {
		boolean actual = Enumerable.of("01", "02", "03").contains("2", this.comparator);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_contains02_02() {
		boolean actual = Enumerable.of("01", "02", "03").contains("4", this.comparator);
		Assert.assertFalse(actual);
	}
}
