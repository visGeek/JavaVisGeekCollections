package com.github.visgeek.utils.collections;

public interface IReadOnlyCollection<T> extends IEnumerable<T> {
	int size();

	boolean isEmpty();

	// 記述する必要がないコードをコメントアウトした。
	// @Override
	// default boolean contains(T item) {
	// return IEnumerable.super.contains(item);
	// }
}
