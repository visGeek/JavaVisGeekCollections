package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Collection;

@SuppressWarnings("unchecked")
public class EnumerableSet<T> extends java.util.HashSet<T> implements ISet<T> {
	// コンストラクター
	public EnumerableSet() {
		super();
	}

	public EnumerableSet(Collection<T> collection) {
		super(Errors.throwIfNull(collection, "collection"));
	}

	public EnumerableSet(Iterable<? extends T> collection) {
		this();

		Errors.throwIfNull(collection, "collection");

		if (collection instanceof Collection<?>) {
			this.addAll((Collection<T>) collection);
		} else {
			this.addAll(collection);
		}
	}

	@SafeVarargs
	public EnumerableSet(T... values) {
		this();
		Errors.throwIfNull(values, "values");
		this.addAll(Arrays.asList(values));
	}

	public EnumerableSet(int initialCapacity) {
		super(initialCapacity);
	}

	public EnumerableSet(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	// フィールド

	// メソッド
	@Override
	public EnumerableSet<T> clone() {
		return new EnumerableSet<T>(this);
	}

	@Override
	@Deprecated
	public boolean contains(Object o) {
		return super.contains(o);
	}

	@Override
	@Deprecated
	public boolean remove(Object o) {
		return super.remove(o);
	}

	// スタティックフィールド
	private static final long serialVersionUID = -2073273720009540371L;
}
