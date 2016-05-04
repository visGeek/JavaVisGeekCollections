package jp.visgeek.utils.collections;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import jp.visgeek.utils.IEqualityComparator;

/**
 * EqualityComparator<T> インターフェイスを使った比較を行うハッシュマップです。
 * 
 * @param <TKey>
 * @param <TValue>
 */
class EquatableMap<TKey, TValue> implements Map<TKey, TValue> {
	// コンストラクター
	private EquatableMap(IEqualityComparator<? super TKey> comparator) {
		this.comparator = comparator;
	}

	// フィールド
	private final LinkedHashMap<Key, TValue> map = new LinkedHashMap<Key, TValue>();

	private final IEqualityComparator<? super TKey> comparator;

	private final Key keyForCompare = new Key(null);

	// メソッド
	@Override
	public void clear() {
		this.map.clear();
	}

	@Override
	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		@SuppressWarnings("unchecked")
		TKey cast = (TKey) key;
		this.keyForCompare.obj = cast;
		return this.map.containsKey(this.keyForCompare);
	}

	@Override
	public boolean containsValue(Object value) {
		return this.map.containsValue(value);
	}

	@Override
	public TValue get(Object key) {
		@SuppressWarnings("unchecked")
		TKey cast = (TKey) key;
		this.keyForCompare.obj = cast;
		return this.map.get(this.keyForCompare);
	}

	@Override
	public Set<TKey> keySet() {
		throw new IllegalStateException();
	}

	@Override
	public TValue put(TKey key, TValue value) {
		return this.map.put(new Key(key), value);
	}

	@Override
	public void putAll(Map<? extends TKey, ? extends TValue> m) {
		for (Map.Entry<? extends TKey, ? extends TValue> entry : m.entrySet()) {
			this.put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public TValue remove(Object key) {
		throw new IllegalStateException();
	}

	@Override
	public int size() {
		return this.map.size();
	}

	@Override
	public Collection<TValue> values() {
		return this.map.values();
	}

	@Override
	public Set<Map.Entry<TKey, TValue>> entrySet() {
		throw new IllegalStateException();
	}

	// クラス
	private class Key {
		public Key(TKey obj) {
			this.obj = obj;
		}

		private TKey obj;

		@Override
		public boolean equals(Object obj) {
			boolean result = false;

			if (obj != null) {
				@SuppressWarnings("unchecked")
				TKey cast = ((Key) obj).obj;
				result = EquatableMap.this.comparator.equals(this.obj, cast);
			}

			return result;
		}

		@Override
		public int hashCode() {
			return EquatableMap.this.comparator.hashCode(this.obj);
		}
	}

	// スタティックメソッド
	public static <TKey, TValue> Map<TKey, TValue> create(IEqualityComparator<? super TKey> comparator) {
		if (comparator == null) {
			return new LinkedHashMap<TKey, TValue>();
		} else {
			return new EquatableMap<TKey, TValue>(comparator);
		}
	}
}
