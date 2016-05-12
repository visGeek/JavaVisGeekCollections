package com.github.visgeek.utils.collections;

import com.github.visgeek.utils.IEqualityComparator;

/**
 * EqualityComparator&lt;T&gt; インターフェイスを使った比較を行うハッシュセットです。
 * @param <T>
 */
abstract class EquatableSet<T> {
	// コンストラクター

	// フィールド

	// メソッド
	public abstract boolean add(T e);

	public abstract boolean contains(T o);

	// スタティックメソッド
	public static <T> EquatableSet<T> create(IEqualityComparator<? super T> comparator) {
		if (comparator == null) {
			return new EquatableSet1<>();
		} else {
			return new EquatableSet2<>(comparator);
		}
	}
}
