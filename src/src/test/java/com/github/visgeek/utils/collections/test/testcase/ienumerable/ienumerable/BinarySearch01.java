package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

//import org.junit.Assert;
//import org.junit.Test;
//
//import com.github.visgeek.utils.collections.Enumerable;
//import com.github.visgeek.utils.collections.IEnumerable;
//
//public class BinarySearch01 {
//	/**
//	 * ソースが空の場合
//	 */
//	@Test
//	public void caseEmpty() {
//		int[] source = new int[] {};
//		int target = 6;
//		int expected = ~source.length;
//		this.test(source, target, expected);
//	}
//
//	/**
//	 * 見つかった場合
//	 */
//	@Test
//	public void found() {
//		int[] source = new int[] { 0, 2, 4, 6, 8, 10, 12 };
//		int target = 6;
//		int expected = 3;
//		this.test(source, target, expected);
//	}
//
//	/**
//	 * 見つからないが探す値より大きい値がある場合
//	 */
//	@Test
//	public void notFound01() {
//		int[] source = new int[] { 0, 2, 4, 6, 8, 10, 12 };
//		int target = 5;
//		int expected = ~3; // 6 の位置の補数
//		this.test(source, target, expected);
//	}
//
//	/**
//	 * 見つからなくて探す値より大きい値がない場合
//	 */
//	@Test
//	public void notFound02() {
//		int[] source = new int[] { 0, 2, 4, 6, 8, 10, 12 };
//		int target = 20;
//		int expected = ~source.length; // 要素数の補数
//		this.test(source, target, expected);
//	}
//
//	private void test(int[] sourceArray, int target, int expected) {
//		IEnumerable<Integer> source = Enumerable.of(sourceArray);
//		int actual = source.binarySearch(target);
//		Assert.assertEquals(expected, actual);
//	}
//}
