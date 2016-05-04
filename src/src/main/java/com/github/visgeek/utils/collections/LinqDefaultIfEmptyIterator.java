package com.github.visgeek.utils.collections;

import java.util.Iterator;

class LinqDefaultIfEmptyIterator<T> extends AbstractSimpleIterator<T, T> {
	// コンストラクター
	public LinqDefaultIfEmptyIterator(Iterable<T> source, Iterable<? extends T> defaultValues) {
		super(source);
		this.defaultValues = defaultValues;
	}

	// フィールド
	private final Iterable<? extends T> defaultValues;

	private Iterator<? extends T> itr = null;

	// プロパティ

	// メソッド
	@Override
	public boolean hasNext() {
		boolean result;

		if (this.itr == null) {
			if (this.iterator.hasNext()) {
				this.itr = this.iterator;
				result = true;
			} else {
				this.itr = this.defaultValues.iterator();
				result = this.itr.hasNext();
			}

		} else {
			result = this.itr.hasNext();
		}

		return result;
	}

	@Override
	public T next() {
		return this.itr.next();
	}

	// スタティックフィールド

	// スタティックイニシャライザー

	// スタティックメソッド
}
