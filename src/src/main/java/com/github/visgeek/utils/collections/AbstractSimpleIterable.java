package com.github.visgeek.utils.collections;

abstract class AbstractSimpleIterable<T, TResult> implements IEnumerable<TResult> {
	// コンストラクター
	public AbstractSimpleIterable(Iterable<T> source) {
		this.source = source;
	}

	// フィールド
	protected final Iterable<T> source;
}
