package com.github.visgeek.utils.collections;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
class ReadOnlyCollectionBase<T, TCollection extends Collection<T>> implements IReadOnlyCollection<T> {
	// コンストラクター
	ReadOnlyCollectionBase(TCollection source) {
		this.source = source;
	}

	// フィールド
	final TCollection source;

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
	public int size() {
		return this.source.size();
	}

	@Override
	public T[] toArray(Class<T> elementClass) {
		T[] array = (T[]) Array.newInstance(elementClass, this.count());
		return this.source.toArray(array);
	}
}
