package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.IEqualityComparator;
import com.github.visgeek.utils.functions.Func1;
import com.github.visgeek.utils.functions.Func2;

class LinqGroupJoinIterator<TOuter, TInner, TKey, TResult> extends Enumerator<TResult> {
	public LinqGroupJoinIterator(
									Iterable<TOuter> source,
									Iterable<TInner> inner,
									Func1<? super TOuter, TKey> outerKeySelector,
									Func1<? super TInner, TKey> innerKeySelector,
									Func2<? super TOuter, ? super IEnumerable<TInner>, TResult> resultSelector,
									IEqualityComparator<? super TKey> comparator) {
		this.source = source;
		this.inner = inner;
		this.outerKeySelector = outerKeySelector;
		this.innerKeySelector = innerKeySelector;
		this.resultSelector = resultSelector;

		this.oItr = this.source.iterator();
		this.innerMap = EquatableMap.create(comparator);
	}

	private final Iterable<TOuter> source;

	private final Iterable<TInner> inner;

	private final Func1<? super TOuter, TKey> outerKeySelector;

	private final Func1<? super TInner, TKey> innerKeySelector;

	private final Func2<? super TOuter, ? super IEnumerable<TInner>, TResult> resultSelector;

	private final Iterator<TOuter> oItr;

	private boolean isRedInner = false;

	private final EquatableMap<TKey, EnumerableList<TInner>> innerMap;

	private TResult current;

	@Override
	public TResult current() {
		return this.current;
	}

	@Override
	public boolean moveNext() {
		// 初回に inner の値をハッシュマップに登録する。
		if (!this.isRedInner) {
			for (TInner innerValue : this.inner) {
				TKey innerKey = this.innerKeySelector.func(innerValue);
				if (!this.innerMap.containsKey(innerKey)) {
					this.innerMap.put(innerKey, new EnumerableList<>());
				}

				this.innerMap.get(innerKey).add(innerValue);
			}
			this.isRedInner = true;
		}

		boolean result = false;
		EnumerableList<TInner> list;

		if (this.oItr.hasNext()) {
			TOuter outerValue = this.oItr.next();
			TKey outerKey = this.outerKeySelector.func(outerValue);

			if (this.innerMap.containsKey(outerKey)) {
				list = this.innerMap.get(outerKey);
			} else {
				list = new EnumerableList<>();
			}

			this.current = this.resultSelector.func(outerValue, list);
			result = true;
		}

		return result;
	}
}
