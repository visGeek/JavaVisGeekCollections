package com.github.visgeek.utils.collections;

import com.github.visgeek.utils.IEqualityComparator;

class EquatableMap2<TKey, TValue> extends EquatableMap<TKey, TValue> {
	// コンストラクター
	EquatableMap2(IEqualityComparator<? super TKey> comparator) {
		this.comparator = comparator;
	}

	// フィールド
	private final EnumerableLinkedMap<Key, TValue> map = new EnumerableLinkedMap<>();

	private final IEqualityComparator<? super TKey> comparator;

	// メソッド
	@Override
	public int count() {
		return this.map.size();
	}

	@Override
	public boolean containsKey(TKey key) {
		Key internalKey = new Key(key);
		return this.map.containsKey2(internalKey);
	}

	@Override
	public TValue get(TKey key) {
		Key internalKey = new Key(key);
		return this.map.getValue(internalKey);
	}

	@Override
	public TValue put(TKey key, TValue value) {
		Key internalKey = new Key(key);
		return this.map.put(internalKey, value);
	}

	@Override
	public IEnumerable<TValue> values() {
		return this.map.enumerateValues();
	}

	@Override
	public IEnumerable<KeyValue> entries() {
		return this.map.select(kv -> new KeyValue(kv.getKey().obj, kv.getValue()));
	}

	// クラス
	private class Key {
		Key(TKey obj) {
			this.obj = obj;
		}

		private final TKey obj;

		@Override
		@SuppressWarnings("unchecked")
		public boolean equals(Object obj) {
			TKey cast = ((Key) obj).obj;
			boolean result = EquatableMap2.this.comparator.equals(this.obj, cast);
			return result;
		}

		@Override
		public int hashCode() {
			return EquatableMap2.this.comparator.hashCode(this.obj);
		}
	}
}
