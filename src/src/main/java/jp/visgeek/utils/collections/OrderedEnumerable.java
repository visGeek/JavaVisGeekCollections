package jp.visgeek.utils.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

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
				if (this.sortedIterator == null) {
					this.sortedIterator = this.createIterator();
				}
				return this.sortedIterator.hasNext();
			}

			@Override
			public T next() {
				if (this.sortedIterator == null) {
					this.sortedIterator = this.createIterator();
				}
				return this.sortedIterator.next();
			}

			private Iterator<T> createIterator() {
				EnumerableList<T> list = new EnumerableList<T>(OrderedEnumerable.this.source);
				Collections.sort(list, OrderedEnumerable.this.comparator());
				return list.iterator();
			}
		};
	}

	// LINQ メソッド
	@Override
	public IOrderedEnumerable<T> thenBy(Comparator<? super T> comparator) {
		Errors.throwIfNull(comparator, "comparator");
		return new OrderedEnumerable<T>(this.source, this.comparator().thenComparing(comparator));
	}

	@Override
	public IOrderedEnumerable<T> thenByDescending(Comparator<? super T> comparator) {
		Errors.throwIfNull(comparator, "comparator");
		return new OrderedEnumerable<T>(this.source, this.comparator().thenComparing(comparator.reversed()));
	}
}
