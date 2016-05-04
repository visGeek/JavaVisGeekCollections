package com.github.visgeek.utils.collections;

abstract class AbstractSimpleEnumerator<T, TResult> extends AbstractEnumerator<TResult> {
	// コンストラクター
	public AbstractSimpleEnumerator(Iterable<T> source) {
		this.source = source;
	}

	// フィールド
	protected final Iterable<T> source;
}
