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
		super(collection);
	}

	public EnumerableSet(Iterable<? extends T> collection) {
		this();
		if (collection instanceof Collection<?>) {
			this.addAll((Collection<T>) collection);
		} else {
			this.addAll(collection);
		}
	}

	@SafeVarargs
	public EnumerableSet(T... values) {
		this();
		this.addAll(Arrays.asList(values));
	}

	public EnumerableSet(int initialCapacity) {
		super(initialCapacity);
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
	private static final long serialVersionUID = -3993841242732244607L;

	// スタティックメソッド
}
