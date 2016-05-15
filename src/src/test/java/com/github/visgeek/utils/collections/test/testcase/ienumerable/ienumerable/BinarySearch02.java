package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.testing.Assert2;

public class BinarySearch02 {
	/**
	 * 引数エラー 開始位置が負数
	 */
	@Test
	public void argError1() {
		int[] source = new int[] { 0, 2, 4, 6, 8, 10, 12 };
		int start = -1;
		int count = source.length;
		int target = 0;

		Action0 action = () -> Enumerable.of(source).binarySearch(start, count, target);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	/**
	 * 引数エラー 検索対象要素数が負数
	 */
	@Test
	public void argError2() {
		int[] source = new int[] { 0, 2, 4, 6, 8, 10, 12 };
		int start = 0;
		int count = -1;
		int target = 0;

		Action0 action = () -> Enumerable.of(source).binarySearch(start, count, target);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	/**
	 * 引数エラー 全体の要素数 < (開始位置 + 検索対象要素数)
	 */
	@Test
	public void argError3() {
		int[] source = new int[] { 0, 2, 4, 6, 8, 10, 12 };
		int start = 1;
		int count = source.length;
		int target = 0;

		Action0 action = () -> Enumerable.of(source).binarySearch(start, count, target);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	/**
	 * ソースが空の場合
	 */
	@Test
	public void empty() {
		int[] source = new int[] {};
		int target = 3;
		int start = 0;
		int count = 0;
		int expected = ~source.length;
		this.test(source, start, count, target, expected);
	}

	/**
	 * 指定した範囲で見つからない 検索対象より大きい値がない 1
	 */
	@Test
	public void notFound01() {
		int[] source = new int[] { 2, 4, 6, 8, 10, 12 };
		int start = 0;
		int count = 1;
		int target = 6;
		int expected = ~(start + count);
		this.test(source, start, count, target, expected);
	}

	/**
	 * 指定した範囲で見つからない 検索対象より大きい値がない 2
	 */
	@Test
	public void notFound02() {
		int[] source = new int[] { 2, 4, 6, 8, 10, 12 };
		int start = 1;
		int count = 3;
		int target = 10;
		int expected = ~(start + count);
		this.test(source, start, count, target, expected);
	}

	/**
	 * 指定した範囲で見つからない 検索対象より大きい値がある
	 */
	@Test
	public void notFound03() {
		int[] source = new int[] { 2, 4, 6, 8, 10, 12 };
		int start = 1;
		int count = 3;
		int target = 5;
		int expected = ~2;
		this.test(source, start, count, target, expected);
	}

	/**
	 * 見つかった場合 検索範囲:全体
	 */
	@Test
	public void foundAll() {
		int[] source = new int[] { 0, 2, 4, 6, 8, 10, 12 };
		int start = 0;
		int count = source.length;
		int target = 6;
		int expected = 3;
		this.test(source, start, count, target, expected);
	}

	/**
	 * 見つかった場合 検索範囲:最初から数個
	 */
	@Test
	public void casePart01() {
		int[] source = new int[] { 0, 2, 4, 6, 8, 10, 12 };
		int start = 0;
		int count = 5;
		int target = 6;
		int expected = 3;
		this.test(source, start, count, target, expected);
	}

	/**
	 * 見つかった場合 検索範囲:最初から数個
	 */
	@Test
	public void casePart02() {
		int[] source = new int[] { 0, 2, 4, 6, 8, 10, 12 };
		int start = 1;
		int count = 5;
		int target = 6;
		int expected = 3;
		this.test(source, start, count, target, expected);
	}

	private void test(int[] sourceArray, int start, int count, int target, int expected) {
		IEnumerable<Integer> source = Enumerable.of(sourceArray);
		int actual = source.binarySearch(start, count, target);
		Assert.assertEquals(expected, actual);
	}
}
