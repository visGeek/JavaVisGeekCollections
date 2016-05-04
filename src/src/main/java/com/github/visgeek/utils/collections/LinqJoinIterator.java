package com.github.visgeek.utils.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.Func2;
import com.github.visgeek.utils.IEqualityComparator;

class LinqJoinIterator<TOuter, TInner, TKey, TResult> extends AbstractEnumerator<TResult> {
	public LinqJoinIterator(Iterable<TOuter> source, Iterable<TInner> inner, Func1<? super TOuter, TKey> outerKeySelector, Func1<? super TInner, TKey> innerKeySelector, Func2<? super TOuter, ? super TInner, TResult> resultSelector, IEqualityComparator<? super TKey> comparator) {
		this.inner = inner;
		this.outerKeySelector = outerKeySelector;
		this.innerKeySelector = innerKeySelector;
		this.resultSelector = resultSelector;

		this.oItr = source.iterator();
		this.iItr = null;
		this.innerMap = EquatableMap.create(comparator);
	}

	private final Iterable<TInner> inner;

	private final Func1<? super TOuter, TKey> outerKeySelector;

	private final Func1<? super TInner, TKey> innerKeySelector;

	private final Func2<? super TOuter, ? super TInner, TResult> resultSelector;

	private final Iterator<TOuter> oItr;

	private Iterator<TInner> iItr;

	private boolean isReadInner = false;

	private final Map<TKey, List<TInner>> innerMap;

	private TOuter outerValue;

	private TResult current;

	@Override
	public TResult current() {
		return this.current;
	}

	@Override
	public boolean moveNext() {
		// 初回に inner の値をハッシュマップに登録する。
		if (!this.isReadInner) {
			for (TInner innerValue : inner) {
				TKey innerKey = innerKeySelector.func(innerValue);
				if (!this.innerMap.containsKey(innerKey)) {
					this.innerMap.put(innerKey, new ArrayList<TInner>());
				}

				this.innerMap.get(innerKey).add(innerValue);
			}
			this.isReadInner = true;
		}

		boolean result = false;

		if (this.iItr == null) {
			while (this.oItr.hasNext()) {
				this.outerValue = this.oItr.next();
				TKey outerKey = outerKeySelector.func(this.outerValue);
				if (this.innerMap.containsKey(outerKey)) {
					this.iItr = this.innerMap.get(outerKey).iterator();
					break;
				}
			}
		}

		if (this.iItr != null) {
			while (this.iItr.hasNext()) {
				this.current = resultSelector.func(this.outerValue, this.iItr.next());
				result = true;
				break;
			}

			if (result == false) {
				this.iItr = null;
				result = this.moveNext();
			}
		}

		return result;
	}
}
