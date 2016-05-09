package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.Func2;
import com.github.visgeek.utils.IEqualityComparator;

abstract class LinqGroupByIterable<T, TKey, TElement, TResult> implements IEnumerable<TResult> {
	// コンストラクター
	public LinqGroupByIterable(IEnumerable<T> source, Func1<? super T, TKey> keySelector, Func1<? super T, TElement> elementSelector, IEqualityComparator<TKey> comparator) {
		Errors.throwIfNull(source, "source");
		Errors.throwIfNull(keySelector, "keySelector");
		Errors.throwIfNull(elementSelector, "elementSelector");

		this.source = source;
		this.keySelector = keySelector;
		this.elementSelector = elementSelector;
		this.comparator = comparator;
	}

	// フィールド
	private final IEnumerable<T> source;

	private final Func1<? super T, TKey> keySelector;

	private final Func1<? super T, TElement> elementSelector;

	private final IEqualityComparator<TKey> comparator;

	// メソッド
	final Lookup<TKey, TElement> lookup() {
		return Lookup.create(this.source, this.keySelector, this.elementSelector, this.comparator);
	}

	@Override
	public abstract Iterator<TResult> iterator();

	// スタティッククラス
	static class Iterable1<T, TKey, TElement> extends LinqGroupByIterable<T, TKey, TElement, IGrouping<TKey, TElement>> {
		// コンストラクター
		public Iterable1(IEnumerable<T> source, Func1<? super T, TKey> keySelector, Func1<? super T, TElement> elementSelector, IEqualityComparator<TKey> comparator) {
			super(source, keySelector, elementSelector, comparator);
		}

		// メソッド
		@Override
		public Iterator<IGrouping<TKey, TElement>> iterator() {
			return this.lookup().iterator();
		}
	}

	static class Iterable2<T, TKey, TElement, TResult> extends LinqGroupByIterable<T, TKey, TElement, TResult> {
		// コンストラクター
		public Iterable2(IEnumerable<T> source, Func1<? super T, TKey> keySelector, Func1<? super T, TElement> elementSelector, Func2<TKey, IEnumerable<? super TElement>, TResult> resultSelector, IEqualityComparator<TKey> comparator) {
			super(source, keySelector, elementSelector, comparator);

			Errors.throwIfNull(resultSelector, "resultSelector");
			this.resultSelector = resultSelector;
		}

		private final Func2<TKey, IEnumerable<? super TElement>, TResult> resultSelector;

		@Override
		public Iterator<TResult> iterator() {
			return this.lookup().applyResultSelector(this.resultSelector).iterator();
		}
	}
}
