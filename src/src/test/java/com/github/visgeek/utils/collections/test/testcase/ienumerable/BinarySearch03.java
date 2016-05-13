package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.ComparatorUtils;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class BinarySearch03 {
	/**
	 * ソースが空の場合
	 */
	@Test
	public void empty() {
		Integer[] source = new Integer[] {};
		int target = 6;
		Comparator<Integer> comparator = ComparatorUtils.getDefault();
		int expected = ~source.length;
		this.test(source, target, comparator, expected);
	}

	/**
	 * 比較子が null。
	 */
	@Test
	public void comparatorIsNull() {
		Integer[] source = new Integer[] { 0, 2, 4, 6, 8, 10, 12 };
		int target = 6;
		Comparator<Integer> comparator = null;
		int expected = 3;
		this.test(source, target, comparator, expected);
	}

	/**
	 * 見つかった場合
	 */
	@Test
	public void found() {
		String[] source = new String[] { "0", "2", "4", "6", "8", "10", "12" };
		String target = "6";
		Comparator<String> comparator = (a, b) -> Integer.parseInt(a) - Integer.parseInt(b);
		int expected = 3;
		this.test(source, target, comparator, expected);
	}

	/**
	 * 見つからないが探す値より大きい値がある場合
	 */
	@Test
	public void notFound01() {
		Integer[] source = new Integer[] { 0, 2, 4, 6, 8, 10, 12 };
		int target = 5;
		Comparator<Integer> comparator = null;
		int expected = ~3; // 6 の位置の補数
		this.test(source, target, comparator, expected);
	}

	/**
	 * 見つからなくて探す値より大きい値がない場合
	 */
	@Test
	public void notFound02() {
		Integer[] source = new Integer[] { 0, 2, 4, 6, 8, 10, 12 };
		int target = 20;
		Comparator<Integer> comparator = null;
		int expected = ~source.length; // 要素数の補数
		this.test(source, target, comparator, expected);
	}

	private <T> void test(T[] sourceArray, T target, Comparator<T> comparator, int expected) {
		IEnumerable<T> source = Enumerable.of(sourceArray);
		int actual = source.binarySearch(target, comparator);
		Assert.assertEquals(expected, actual);
	}
}
