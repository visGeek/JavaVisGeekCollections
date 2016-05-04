package jp.visgeek.utils;

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
	private static Comparator<Comparable<Object>> defaultComparator = Comparator.nullsFirst(Comparator.naturalOrder());

	// スタティックイニシャライザー

	// スタティックメソッド
	/**
	 * 既定の Comparator&lt;T&gt; を取得します。
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> Comparator<T> getDefault() {
		return (Comparator<T>) ComparatorUtils.defaultComparator;
	}

	/**
	 * 指定した比較方法で Comparator&lt;T&gt; を作成します。
	 * @param comparison
	 * @return
	 */
	public static <T> Comparator<T> create(Comparator<? super T> comparator) {
		return new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				return comparator.compare(o1, o2);
			}
		};
	}

	/**
	 * 指定した値の順番を元に Comparator&lt;T&gt; を作成します。
	 * @param orders
	 * @return
	 */
	public static <T> Comparator<T> create(Iterable<? extends T> orders) {
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
	public static <T> Comparator<T> create(T... orders) {
		HashMap<T, Integer> orderMap = new HashMap<>();

		int order = 0;
		for (T value : orders) {
			order++;
			orderMap.put(value, order);
		}

		return ComparatorUtils.createComparator(orderMap);
	}

	private static <T> Comparator<T> createComparator(HashMap<T, Integer> orderMap) {
		return new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				int result = 0;

				Integer order1 = orderMap.get(o1);
				Integer order2 = orderMap.get(o2);

				if (order1 == null) {
					if (order2 == null) {
						result = 0;
					} else {
						result = -1;
					}
				} else {
					if (order2 == null) {
						result = 1;
					} else {
						result = order1.compareTo(order2);
					}
				}

				return result;
			}
		};
	}
}
