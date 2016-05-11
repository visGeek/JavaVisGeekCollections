package com.github.visgeek.utils.collections;

import com.github.visgeek.utils.Func2;

class LinqSelectIterator<T, TResult> extends AbstractConvertedIterator<T, TResult> {
	public LinqSelectIterator(Iterable<T> source, Func2<? super T, Integer, TResult> selector) {
		super(source);
		this.selector = selector;
	}

	private final Func2<? super T, Integer, TResult> selector;

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
