package com.github.visgeek.utils.collections;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

class KeyValueCollection<K, V> implements IKeyValueCollection<K, V> {
	public KeyValueCollection(IReadOnlyMap<K, V> map) {
		this.map = map;
	}

	private final IReadOnlyMap<K, V> map;

	@Override
	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	@Override
	public boolean containsKey(K key) {
		return this.map.containsKey(key);
	}

	@Override
	public V get(K key) {
		return this.map.get(key);
	}

	@Override
	public V getValueOrThrow(K key) {
		return this.map.getValueOrThrow(key);
	}

	@Override
	public V getValueOrDefault(K key, V defaultValue) {
		return this.map.getValueOrDefault(key, defaultValue);
	}

	@Override
	public IEnumerable<K> enumerateKeys() {
		return this.map.enumerateKeys();
	}

	@Override
	public IEnumerable<Entry<K, V>> enumerateEntries() {
		return this.map;
	}

	@Override
	public Set<K> keySet() {
		return this.map.keySet();
	}

	@Override
	public int size() {
		return this.map.size();
	}

	@Override
	public Iterator<V> iterator() {
		return this.map.values().iterator();
	}
}
