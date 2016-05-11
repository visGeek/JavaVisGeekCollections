package com.github.visgeek.utils.collections;

import java.util.Iterator;

/**
 * ソースの要素の型とは別の型の要素を列挙できる列挙子です。
 *
 * @param <T>
 * @param <TResult>
 */
abstract class AbstractConvertedIterator<T, TResult> implements Iterator<TResult> {
	// コンストラクター
	public AbstractConvertedIterator(Iterable<T> source) {
		this.source = source;
		this.iterator = source.iterator();
	}

	// フィールド
	final Iterable<T> source;

	final Iterator<T> iterator;
}
