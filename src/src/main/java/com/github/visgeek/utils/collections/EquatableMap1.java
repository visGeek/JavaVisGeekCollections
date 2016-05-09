package com.github.visgeek.utils.collections;

import java.util.Collection;

/**
 * EqualityComparator&lt;T&gt; インターフェイスを使った比較を行うハッシュマップです。
 *
 * @param <TKey>
 * @param <TValue>
 */
class EquatableMap1<TKey, TValue> extends EquatableMap<TKey, TValue> {
	// コンストラクター

	// フィールド
	private final EnumerableLinkedMap<TKey, TValue> map = new EnumerableLinkedMap<>();

	// メソッド
	@Override
	public boolean containsKey(TKey key) {
		return this.map.containsKey2(key);
	}

	@Override
	public TValue get(TKey key) {
		return this.map.getValue(key);
	}

	@Override
	public TValue put(TKey key, TValue value) {
		return this.map.put(key, value);
	}

	@Override
	public Collection<TValue> values() {
		return this.map.values();
	}

	@Override
	public IEnumerable<KeyValue> entries() {
		return this.map.select(kv -> new KeyValue(kv.getKey(), kv.getValue()));
	}
}
