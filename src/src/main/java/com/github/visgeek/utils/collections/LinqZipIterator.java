package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.Func2;

class LinqZipIterator<TFirst, TSecond, TResult> extends AbstractConvertedIterator<TFirst, TResult> {
	public LinqZipIterator(Iterable<TFirst> source, Iterable<TSecond> second, Func2<? super TFirst, ? super TSecond, TResult> resultSelector) {
		super(source);
		this.resultSelector = resultSelector;
		this.itr = second.iterator();
	}

	private final Func2<? super TFirst, ? super TSecond, TResult> resultSelector;

	private final Iterator<TSecond> itr;

	@Override
	public boolean hasNext() {
		return this.iterator.hasNext() && this.itr.hasNext();
	}

	@Override
	public TResult next() {
		return resultSelector.func(this.iterator.next(), this.itr.next());
	}
}
