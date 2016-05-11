package com.github.visgeek.utils.collections;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

class ListEnumerable<T> implements IListEnumerable<T> {
	// コンストラクター
	ListEnumerable(List<T> source) {
		this.source = Collections.unmodifiableList(source);
	}

	@SafeVarargs
	ListEnumerable(T... source) {
		this(Arrays.asList(source));
	}

	// フィールド
	private final List<T> source;

	// メソッド
	@Override
	public int count() {
		return this.source.size();
	}

	@Override
	public boolean contains(T item) {
		return this.source.contains(item);
	}

	@Override
	public Stream<T> asStream() {
		return this.source.stream();
	}

	@Override
	public Iterator<T> iterator() {
		return this.source.iterator();
	}

	@Override
	public T elementAt(int index) {
		try {
			return this.source.get(index);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw Errors.argumentOfOutOfRange("index");
		}
	}

	@Override
	public T[] toArray(Class<T> elementClass) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) Array.newInstance(elementClass, this.count());

		return this.source.toArray(array);
	}
}
