package com.github.visgeek.utils.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import com.github.visgeek.utils.ComparatorUtils;

class OrderedEnumerable<T> implements IOrderedEnumerable<T> {
	// コンストラクター
	public OrderedEnumerable(Iterable<T> source, Comparator<? super T> comparator) {
		this.source = source;

		@SuppressWarnings("unchecked")
		Comparator<T> cpr = (Comparator<T>) comparator;
		this.comparator = cpr;
	}

	// フィールド
	private final Iterable<T> source;

	private final Comparator<T> comparator;

	// メソッド
	@Override
	public Comparator<T> comparator() {
		return this.comparator;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Iterator<T> sortedIterator = null;

			@Override
			public boolean hasNext() {
				this.tryCreateIterator();
				return this.sortedIterator.hasNext();
			}

			@Override
			public T next() {
				this.tryCreateIterator();
				return this.sortedIterator.next();
			}

			private void tryCreateIterator() {
				if (this.sortedIterator == null) {
					EnumerableList<T> list = new EnumerableList<>(OrderedEnumerable.this.source);
					Collections.sort(list, OrderedEnumerable.this.comparator());
					this.sortedIterator = list.iterator();
				}
			}
		};
	}

	// LINQ メソッド
	@Override
	public IOrderedEnumerable<T> thenBy(Comparator<? super T> comparator) {
		if (comparator == null) {
			comparator = ComparatorUtils.getDefault();
		}

		return new OrderedEnumerable<>(this.source, this.comparator().thenComparing(comparator));
	}

	@Override
	public IOrderedEnumerable<T> thenByDescending(Comparator<? super T> comparator) {
		if (comparator == null) {
			comparator = ComparatorUtils.getDefault();
		}

		return new OrderedEnumerable<>(this.source, this.comparator().thenComparing(comparator.reversed()));
	}
}
