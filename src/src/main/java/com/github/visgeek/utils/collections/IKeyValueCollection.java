package com.github.visgeek.utils.collections;

import java.util.Map.Entry;
import java.util.Set;

public interface IKeyValueCollection<K, V> extends IReadOnlyCollection<V> {
	boolean containsKey(K key);

	V get(K key);

	V getValueOrThrow(K key);

	V getValueOrDefault(K key, V defaultValue);

	IEnumerable<K> enumerateKeys();

	IEnumerable<Entry<K, V>> enumerateEntries();

	Set<K> keySet();

	@Override
	int size();
}
