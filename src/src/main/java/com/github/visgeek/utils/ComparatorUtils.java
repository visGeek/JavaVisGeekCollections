package com.github.visgeek.utils;

import java.util.Comparator;
import java.util.HashMap;

public class ComparatorUtils {
	// コンストラクター
	private ComparatorUtils() {
	}

	// フィールド

	// プロパティ

	// メソッド

	// スタティックフィールド
	private static Comparator<?> defaultComparator = Comparator.nullsFirst(Comparator.naturalOrder());

	// スタティックイニシャライザー

	// スタティックメソッド
	/**
	 * 既定の Comparator&lt;T&gt; を取得します。
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Comparator<T> getDefault() {
		return (Comparator<T>) ComparatorUtils.defaultComparator;
	}

	/**
	 * 指定した値の順番を元に Comparator&lt;T&gt; を作成します。
	 * @param orders
	 * @return
	 */
	public static <T> Comparator<T> createFromOrders(Iterable<? extends T> orders) {
		HashMap<T, Integer> orderMap = new HashMap<>();

		int order = 0;
		for (T value : orders) {
			order++;
			orderMap.put(value, order);
		}

		return ComparatorUtils.createComparator(orderMap);
	}

	/**
	 * 指定した値の順番を元に Comparator&lt;T&gt; を作成します。
	 * @param orders
	 * @return
	 */
	@SafeVarargs
	public static <T> Comparator<T> createFromOrders(T... orders) {
		HashMap<T, Integer> orderMap = new HashMap<>();

		int order = 0;
		for (T value : orders) {
			order++;
			orderMap.put(value, order);
		}

		return ComparatorUtils.createComparator(orderMap);
	}

	private static <T> Comparator<T> createComparator(HashMap<T, Integer> orderMap) {
		return (o1, o2) -> {
			Integer order1 = orderMap.get(o1);
			Integer order2 = orderMap.get(o2);
			return ComparatorUtils.<Integer> getDefault().compare(order1, order2);
		};
	}
}
