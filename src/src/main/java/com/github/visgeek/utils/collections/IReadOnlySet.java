package com.github.visgeek.utils.collections;

public interface IReadOnlySet<T> extends IReadOnlyCollection<T> {
	@Override
	int size();

	boolean containsValue(T obj);
}
