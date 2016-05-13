package com.github.visgeek.utils.collections;

import com.github.visgeek.utils.IndexedFunc1;

class LinqSelectIterator<T, TResult> extends AbstractConvertedIterator<T, TResult> {
	public LinqSelectIterator(Iterable<T> source, IndexedFunc1<? super T, TResult> selector) {
		super(source);
		this.selector = selector;
	}

	private final IndexedFunc1<? super T, TResult> selector;

	private int i = -1;

	@Override
	public boolean hasNext() {
		return this.iterator.hasNext();
	}

	@Override
	public TResult next() {
		this.i++;
		return this.selector.func(this.iterator.next(), this.i);
	}
}
