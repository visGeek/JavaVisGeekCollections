package com.github.visgeek.utils.collections;

public interface IGrouping<TKey, TElement> extends IEnumerable<TElement> {
	TKey key();
}
