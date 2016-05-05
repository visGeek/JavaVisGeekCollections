package com.github.visgeek.utils.collections;

public interface ILookup<TKey, TElement> extends IEnumerable<IGrouping<TKey, TElement>> {
	// 記述する必要がないのでコメントアウトしてある。
	// @Override
	// default int count() {
	// return IEnumerable.super.count();
	// }

	IEnumerable<TElement> get(TKey key);
}
