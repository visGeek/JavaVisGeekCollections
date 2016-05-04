package com.github.visgeek.utils.collections;

import java.util.Iterator;

class LinqConcateIterator<T> implements Iterator<T> {
	// コンストラクター
	public LinqConcateIterator(Iterable<T> source, Iterable<? extends T> second) {
		this.second = second;
		this.itr = source.iterator();
		this.isSwitched = false;
	}

	// フィールド
	private final Iterable<? extends T> second;

	private Iterator<? extends T> itr;

	private boolean isSwitched;

	// プロパティ

	// メソッド
	@Override
	public boolean hasNext() {
		boolean result = false;

		result = this.itr.hasNext();

		if (!this.isSwitched) {
			if (!result) {
				this.itr = this.second.iterator();
				result = this.itr.hasNext();
				this.isSwitched = true;
			}
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
