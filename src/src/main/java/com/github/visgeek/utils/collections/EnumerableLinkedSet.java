package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Collection;

@SuppressWarnings("unchecked")
public class EnumerableLinkedSet<T> extends java.util.LinkedHashSet<T> implements ISet<T> {
	// コンストラクター
	public EnumerableLinkedSet() {
		super();
	}

	public EnumerableLinkedSet(Collection<T> collection) {
		super(Errors.throwIfNull(collection, "collection"));
	}

	public EnumerableLinkedSet(Iterable<? extends T> collection) {
		this();

		Errors.throwIfNull(collection, "collection");

		if (collection instanceof Collection<?>) {
			this.addAll((Collection<T>) collection);
		} else {
			this.addAll(collection);
		}
	}

	@SafeVarargs
	public EnumerableLinkedSet(T... values) {
		this();
		Errors.throwIfNull(values, "values");
		this.addAll(Arrays.asList(values));
	}

	public EnumerableLinkedSet(int initialCapacity) {
		super(initialCapacity);
	}

	public EnumerableLinkedSet(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	// フィールド

	// メソッド
	@Override
	public EnumerableLinkedSet<T> clone() {
		return new EnumerableLinkedSet<>(this);
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
	private static final long serialVersionUID = -3993841242732244607L;
}
