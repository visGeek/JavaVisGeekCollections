package com.github.visgeek.utils.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.Func2;
import com.github.visgeek.utils.IEqualityComparator;

class Lookup<TKey, TElement> implements ILookup<TKey, TElement> {
	// コンストラクター
	private Lookup(IEqualityComparator<? super TKey> comparator) {
		this.map = EquatableMap.create(comparator);
	}

	// フィールド
	public final Map<TKey, IGrouping<TKey, TElement>> map;

	// メソッド
	final <TResult> IEnumerable<TResult> applyResultSelector(final Func2<TKey, IEnumerable<? super TElement>, TResult> resultSelector) {
		final Iterator<Entry<TKey, IGrouping<TKey, TElement>>> iterator = this.map.entrySet().iterator();

		Iterable<TResult> iterable = new Iterable<TResult>() {
			@Override
			public Iterator<TResult> iterator() {
				return new Iterator<TResult>() {
					@Override
					public boolean hasNext() {
						return iterator.hasNext();
					}

					@Override
					public TResult next() {
						Entry<TKey, IGrouping<TKey, TElement>> entry = iterator.next();
						return resultSelector.func(entry.getKey(), entry.getValue());
					}
				};
			}
		};

		return Enumerable.of(iterable);
	}

	private final Grouping<TKey, TElement> getGrouping(TKey key, boolean create) {
		Grouping<TKey, TElement> grouping;

		if (this.map.containsKey(key)) {
			grouping = (Grouping<TKey, TElement>) this.map.get(key);

		} else if (create) {
			grouping = new Grouping<TKey, TElement>(key);
			this.map.put(key, grouping);

		} else {
			grouping = null;
		}

		return grouping;
	}

	@Override
	public final IEnumerable<TElement> get(TKey key) {
		if (this.map.containsKey(key)) {
			return this.map.get(key);
		} else {
			return Enumerable.empty();
		}
	}

	@Override
	public final Iterator<IGrouping<TKey, TElement>> iterator() {
		return this.map.values().iterator();
	}

	// スタティックフィールド

	// スタティックメソッド
	public static <T, TKey, TElement> Lookup<TKey, TElement> create(Iterable<T> source, Func1<? super T, TKey> keySelector, Func1<? super T, TElement> elementSelector, IEqualityComparator<? super TKey> comparator) {
		Errors.throwIfNull(source, "source");
		Errors.throwIfNull(keySelector, "keySelector");
		Errors.throwIfNull(elementSelector, "elementSelector");

		Lookup<TKey, TElement> lookup = new Lookup<TKey, TElement>(comparator);

		for (T local : source) {
			lookup.getGrouping(keySelector.func(local), true).add(elementSelector.func(local));
		}

		return lookup;
	}
}
