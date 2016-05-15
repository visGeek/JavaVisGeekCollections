package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.IEqualityComparator;
import com.github.visgeek.utils.functions.Func1;
import com.github.visgeek.utils.functions.Func2;

class Lookup<TKey, TElement> implements ILookup<TKey, TElement> {
	// コンストラクター
	private Lookup(IEqualityComparator<? super TKey> comparator) {
		this.map = EquatableMap.create(comparator);
	}

	// フィールド
	private final EquatableMap<TKey, Grouping<TKey, TElement>> map;

	// メソッド
	final <TResult> IEnumerable<TResult> applyResultSelector(Func2<TKey, ? super IEnumerable<TElement>, TResult> resultSelector) {
		return this.map.entries().select(kv -> resultSelector.func(kv.key, kv.value));
	}

	@Override
	public final boolean containsKey(TKey key) {
		return this.map.containsKey(key);
	}

	@Override
	public final int count() {
		return this.map.count();
	}

	private final Grouping<TKey, TElement> getOrCreateGrouping(TKey key) {
		Grouping<TKey, TElement> grouping;

		if (this.map.containsKey(key)) {
			grouping = this.map.get(key);

		} else {
			grouping = new Grouping<>(key);
			this.map.put(key, grouping);
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
		return this.map.values().<IGrouping<TKey, TElement>> cast().iterator();
	}

	// スタティックフィールド

	// スタティックメソッド
	static <T, TKey, TElement> Lookup<TKey, TElement> create(
			Iterable<T> source,
			Func1<? super T, TKey> keySelector,
			Func1<? super T, TElement> elementSelector,
			IEqualityComparator<? super TKey> comparator) {

		Errors.throwIfNull(source, "source");
		Errors.throwIfNull(keySelector, "keySelector");
		Errors.throwIfNull(elementSelector, "elementSelector");

		Lookup<TKey, TElement> lookup = new Lookup<>(comparator);

		for (T local : source) {
			lookup.getOrCreateGrouping(keySelector.func(local)).add(elementSelector.func(local));
		}

		return lookup;
	}
}
