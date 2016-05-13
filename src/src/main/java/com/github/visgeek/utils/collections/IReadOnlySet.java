package com.github.visgeek.utils.collections;

public interface IReadOnlySet<T> extends IReadOnlyCollection<T> {
	boolean containsValue(T obj);

	@Override
	int size();
}
