package com.github.visgeek.utils.collections;

interface ICollectionEnumerable<T> extends IEnumerable<T> {
	@Override
	default boolean any() {
		return this.count() != 0;
	}

	@Override
	int count();

	@Override
	boolean contains(T item);
}
