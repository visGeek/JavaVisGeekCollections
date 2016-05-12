package com.github.visgeek.utils.collections;

public interface IReadOnlyCollection<T> extends ICollectionEnumerable<T> {
	int size();

	boolean isEmpty();

	@Override
	default int count() {
		return this.size();
	}
}
