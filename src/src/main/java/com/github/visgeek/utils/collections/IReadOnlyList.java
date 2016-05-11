package com.github.visgeek.utils.collections;

public interface IReadOnlyList<T> extends IReadOnlyCollection<T>, IListEnumerable<T> {
	T get(int index);
}
