package com.github.visgeek.utils.collections;

public interface IReadOnlyCollection<T> extends IEnumerable<T> {
	int size();

	boolean isEmpty();

	@Override
	default boolean contains(T item) {
		return IEnumerable.super.contains(item);
	}
}
