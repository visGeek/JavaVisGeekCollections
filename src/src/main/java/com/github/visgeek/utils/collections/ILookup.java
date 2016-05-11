package com.github.visgeek.utils.collections;

public interface ILookup<TKey, TElement> extends IEnumerable<IGrouping<TKey, TElement>> {
	@Override
	int count();

	boolean containsKey(TKey key);

	IEnumerable<TElement> get(TKey key);
}
