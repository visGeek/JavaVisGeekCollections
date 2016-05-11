package com.github.visgeek.utils.collections;

public interface IReadOnlyCollection<T> extends ICollectionEnumerable<T> {
	int size();

	boolean isEmpty();

	@Override
	boolean contains(T item);
}
