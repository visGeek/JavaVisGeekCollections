package com.github.visgeek.utils.collections;

import java.util.Collection;

import com.github.visgeek.utils.IEqualityComparator;

/**
 * EqualityComparator&lt;T&gt; インターフェイスを使った比較を行うハッシュマップです。
 *
 * @param <TKey>
 * @param <TValue>
 */
abstract class EquatableMap<TKey, TValue> {
	// コンストラクター

	// フィールド

	// メソッド
	public abstract boolean containsKey(TKey key);

	public abstract TValue get(TKey key);

	public abstract TValue put(TKey key, TValue value);

	public abstract Collection<TValue> values();

	public abstract IEnumerable<KeyValue> entries();

	class KeyValue {
		public KeyValue(TKey key, TValue value) {
			this.key = key;
			this.value = value;
		}

		final TKey key;

		final TValue value;
	}

	// スタティックメソッド
	public static <TKey, TValue> EquatableMap<TKey, TValue> create(IEqualityComparator<? super TKey> comparator) {
		if (comparator == null) {
			return new EquatableMap1<>();
		} else {
			return new EquatableMap2<>(comparator);
		}
	}
}
