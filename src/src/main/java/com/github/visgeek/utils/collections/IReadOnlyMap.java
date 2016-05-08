package com.github.visgeek.utils.collections;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

import com.github.visgeek.utils.Func0;
import com.github.visgeek.utils.Func1;

public interface IReadOnlyMap<K, V> extends IReadOnlyCollection<Entry<K, V>> {
	boolean containsKey(K key);

	boolean containsValue(V value);

	V get(K key);

	default V getValueOrThrow(K key) {
		if (this.containsKey(key)) {
			return this.get(key);
		} else {
			throw new IllegalArgumentException(String.format("key '%s' is not found.", key));
		}
	}

	V getValueOrDefault(K key, V defaultValue);

	default V getValueOrDefault(K key, Func0<? extends V> defaultValue) {
		if (this.containsKey(key)) {
			return this.get(key);
		} else {
			return defaultValue.func();
		}
	}

	default V getValueOrDefault(K key, Func1<? super K, ? extends V> defaultValue) {
		if (this.containsKey(key)) {
			return this.get(key);
		} else {
			return defaultValue.func(key);
		}
	}

	IEnumerable<K> enumerateKeys();

	IEnumerable<V> enumerateValues();

	Set<K> keySet();

	@Override
	int size();

	Collection<V> values();

	IKeyValueCollection<K, V> toKeyValueCollection();

	public static <K, V extends V2, V2> IReadOnlyMap<K, V2> cast(IReadOnlyMap<K, V> map) {
		@SuppressWarnings("unchecked")
		IReadOnlyMap<K, V2> result = (IReadOnlyMap<K, V2>) map;
		return result;
	}
}
