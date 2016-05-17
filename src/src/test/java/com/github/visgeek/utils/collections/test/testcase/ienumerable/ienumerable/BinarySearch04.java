package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

//import java.util.Comparator;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import com.github.visgeek.utils.ComparatorUtils;
//import com.github.visgeek.utils.collections.Enumerable;
//import com.github.visgeek.utils.collections.IEnumerable;
//import com.github.visgeek.utils.functions.Action0;
//import com.github.visgeek.utils.testing.Assert2;
//
//public class BinarySearch04 {
//	/**
//	 * 引数エラー 開始位置が負数
//	 */
//	@Test
//	public void argError1() {
//		String[] source = new String[] { "0", "2", "4", "6", "8", "10", "12" };
//		int start = -1;
//		int count = source.length;
//		String target = "00";
//		Comparator<String> comparator = ComparatorUtils.getDefault();
//
//		Action0 action = () -> Enumerable.of(source).binarySearch(start, count, target, comparator);
//		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
//	}
//
//	/**
//	 * 引数エラー 検索対象要素数が負数
//	 */
//	@Test
//	public void argError2() {
//		String[] source = new String[] { "0", "2", "4", "6", "8", "10", "12" };
//		int start = 0;
//		int count = -1;
//		String target = "00";
//		Comparator<String> comparator = ComparatorUtils.getDefault();
//
//		Action0 action = () -> Enumerable.of(source).binarySearch(start, count, target, comparator);
//		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
//	}
//
//	/**
//	 * 引数エラー 全体の要素数 < (開始位置 + 検索対象要素数)
//	 */
//	@Test
//	public void argError3() {
//		String[] source = new String[] { "0", "2", "4", "6", "8", "10", "12" };
//		int start = 1;
//		int count = source.length;
//		String target = "00";
//		Comparator<String> comparator = ComparatorUtils.getDefault();
//
//		Action0 action = () -> Enumerable.of(source).binarySearch(start, count, target, comparator);
//		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
//	}
//
//	/**
//	 * ソースが空の場合
//	 */
//	@Test
//	public void empty() {
//		String[] source = new String[] {};
//		String target = "03";
//		int start = 0;
//		int count = 0;
//		int expected = ~source.length;
//		Comparator<String> comparator = (a, b) -> Integer.parseInt(a) - Integer.parseInt(b);
//
//		this.test(source, start, count, target, expected, comparator);
//	}
//
//	/**
//	 * 指定した範囲で見つからない 検索対象より大きい値がない 1
//	 */
//	@Test
//	public void notFound01() {
//		String[] source = new String[] { "2", "4", "6", "8", "10", "12" };
//		int start = 0;
//		int count = 1;
//		String target = "06";
//		int expected = ~(start + count);
//		Comparator<String> comparator = (a, b) -> Integer.parseInt(a) - Integer.parseInt(b);
//
//		this.test(source, start, count, target, expected, comparator);
//	}
//
//	/**
//	 * 指定した範囲で見つからない 検索対象より大きい値がない 2
//	 */
//	@Test
//	public void notFound02() {
//		String[] source = new String[] { "2", "4", "6", "8", "10", "12" };
//		int start = 1;
//		int count = 3;
//		String target = "10";
//		int expected = ~(start + count);
//		Comparator<String> comparator = (a, b) -> Integer.parseInt(a) - Integer.parseInt(b);
//
//		this.test(source, start, count, target, expected, comparator);
//	}
//
//	/**
//	 * 指定した範囲で見つからない 検索対象より大きい値がある
//	 */
//	@Test
//	public void notFound03() {
//		String[] source = new String[] { "2", "4", "6", "8", "10", "12" };
//		int start = 1;
//		int count = 3;
//		String target = "05";
//		int expected = ~2;
//		Comparator<String> comparator = (a, b) -> Integer.parseInt(a) - Integer.parseInt(b);
//
//		this.test(source, start, count, target, expected, comparator);
//	}
//
//	/**
//	 * 見つかった場合 検索範囲:全体
//	 */
//	@Test
//	public void foundAll() {
//		String[] source = new String[] { "0", "2", "4", "6", "8", "10", "12" };
//		int start = 0;
//		int count = source.length;
//		String target = "06";
//		int expected = 3;
//		Comparator<String> comparator = (a, b) -> Integer.parseInt(a) - Integer.parseInt(b);
//
//		this.test(source, start, count, target, expected, comparator);
//	}
//
//	/**
//	 * 見つかった場合 検索範囲:最初から数個
//	 */
//	@Test
//	public void casePart01() {
//		String[] source = new String[] { "0", "2", "4", "6", "8", "10", "12" };
//		int start = 0;
//		int count = 5;
//		String target = "06";
//		int expected = 3;
//		Comparator<String> comparator = (a, b) -> Integer.parseInt(a) - Integer.parseInt(b);
//
//		this.test(source, start, count, target, expected, comparator);
//	}
//
//	/**
//	 * 見つかった場合 検索範囲:最初から数個
//	 */
//	@Test
//	public void casePart02() {
//		String[] source = new String[] { "0", "2", "4", "6", "8", "10", "12" };
//		int start = 1;
//		int count = 5;
//		String target = "06";
//		int expected = 3;
//		Comparator<String> comparator = (a, b) -> Integer.parseInt(a) - Integer.parseInt(b);
//
//		this.test(source, start, count, target, expected, comparator);
//	}
//
//	private <T> void test(T[] sourceArray, int start, int count, T target, int expected, Comparator<T> comparator) {
//		IEnumerable<T> source = Enumerable.of(sourceArray);
//		int actual = source.binarySearch(start, count, target, comparator);
//		Assert.assertEquals(expected, actual);
//	}
//}
