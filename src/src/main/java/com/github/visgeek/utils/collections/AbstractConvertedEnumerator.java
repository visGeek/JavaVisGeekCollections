package com.github.visgeek.utils.collections;

/**
 * ソースの要素の型とは別の型の要素を列挙できる列挙子です。
 *
 * @param <T>
 * @param <TResult>
 */
abstract class AbstractConvertedEnumerator<T, TResult> extends Enumerator<TResult> {
	// コンストラクター
	public AbstractConvertedEnumerator(Iterable<T> source) {
		this.source = source;
	}

	// フィールド
	protected final Iterable<T> source;
}
