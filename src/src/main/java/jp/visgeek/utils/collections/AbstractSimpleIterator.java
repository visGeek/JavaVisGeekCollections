package jp.visgeek.utils.collections;

import java.util.Iterator;

abstract class AbstractSimpleIterator<T, TResult> implements Iterator<TResult> {
	// コンストラクター
	public AbstractSimpleIterator(Iterable<T> source) {
		this.source = source;
		this.iterator = source.iterator();
	}

	// フィールド
	protected final Iterable<T> source;

	protected final Iterator<T> iterator;

	// メソッド
	@Override
	public abstract boolean hasNext();

	@Override
	public abstract TResult next();

	@Override
	public final void remove() {
		throw Errors.invalidOperation();
	}
}
