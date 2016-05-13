package com.github.visgeek.utils.collections;

/**
 * java.util.LinkedHashMap&lt;K, V&gt; の機能と IEnumerable&lt;T&gt; の機能を提供します。
 * @param <K>
 * @param <V>
 */
public class EnumerableLinkedMap<K, V> extends java.util.LinkedHashMap<K, V> implements IMap<K, V> {
	// コンストラクター
	public EnumerableLinkedMap() {
		super();
	}

	public EnumerableLinkedMap(java.util.Map<? extends K, ? extends V> map) {
		super(Errors.throwIfNull(map, "map"));
	}

	public EnumerableLinkedMap(int initialCapacity) {
		super(initialCapacity);
	}

	public EnumerableLinkedMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	public EnumerableLinkedMap(int initialCapacity, float loadFactor, boolean accessOrder) {
		super(initialCapacity, loadFactor, accessOrder);
	}

	public EnumerableLinkedMap(IReadOnlyMap<? extends K, ? extends V> map) {
		this();

		Errors.throwIfNull(map, "map");

		for (Entry<? extends K, ? extends V> kv : map) {
			this.put(kv.getKey(), kv.getValue());
		}
	}

	// フィールド

	// メソッド
	@Override
	public EnumerableLinkedMap<K, V> clone() {
		return new EnumerableLinkedMap<>((java.util.Map<? extends K, ? extends V>) this);
	}

	@Override
	@Deprecated
	public boolean containsKey(Object key) {
		return super.containsKey(key);
	}

	@Override
	@Deprecated
	public boolean containsValue(Object value) {
		return super.containsValue(value);
	}

	@Override
	@Deprecated
	public V get(Object key) {
		return super.get(key);
	}

	@Override
	@Deprecated
	public V getOrDefault(Object paramObject, V paramV) {
		return super.getOrDefault(paramObject, paramV);
	}

	@Override
	@Deprecated
	public V remove(Object key) {
		return super.remove(key);
	}

	@Override
	public String toString() {
		return String.format("size:%d", this.size());
	}

	// スタティックフィールド
	private static final long serialVersionUID = -7179232799171941533L;
}
