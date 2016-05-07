package com.github.visgeek.utils.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Stream;

class CollectionEnumerable<T> implements ICollectionEnumerable<T> {
	// コンストラクター
	CollectionEnumerable(Collection<T> source) {
		this.source = Collections.unmodifiableCollection(source);
	}

	// フィールド
	private final Collection<T> source;

	// メソッド
	@Override
	public Iterator<T> iterator() {
		return this.source.iterator();
	}

	@Override
	public Stream<T> asStream() {
		return this.source.stream();
	}

	@Override
	public boolean contains(T item) {
		return this.source.contains(item);
	}

	@Override
	public int count() {
		return this.source.size();
	}

	@Override
	public T[] toArray(Class<T> elementClass) {
		return this.source.toArray(null);
	}
}
