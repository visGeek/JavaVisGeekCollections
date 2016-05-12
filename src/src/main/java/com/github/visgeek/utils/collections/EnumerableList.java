package com.github.visgeek.utils.collections;

import java.util.Collection;

@SuppressWarnings("unchecked")
public class EnumerableList<T> extends java.util.ArrayList<T> implements IList<T> {
	// コンストラクター
	public EnumerableList() {
		super();
	}

	public EnumerableList(Collection<? extends T> collection) {
		super(collection);
	}

	public EnumerableList(Iterable<? extends T> collection) {
		this();
		if (collection instanceof Collection<?>) {
			this.addAll((Collection<T>) collection);
		} else {
			this.addAll(collection);
		}
	}

	@SafeVarargs
	public EnumerableList(T... values) {
		this(values.length);

		for (T value : values) {
			this.add(value);
		}
	}

	public EnumerableList(int initialCapacity) {
		super(initialCapacity);
	}

	// フィールド

	// メソッド
	@Override
	public EnumerableList<T> clone() {
		return new EnumerableList<>(this);
	}

	@Override
	@Deprecated
	public boolean contains(Object o) {
		return super.contains(o);
	}

	@Override
	@Deprecated
	public int indexOf(Object o) {
		return super.indexOf(o);
	}

	@Override
	@Deprecated
	public int lastIndexOf(Object o) {
		return super.lastIndexOf(o);
	}

	@Override
	@Deprecated
	public T remove(int index) {
		return super.remove(index);
	}

	@Override
	@Deprecated
	public boolean remove(Object o) {
		return super.remove(o);
	}

	@Override
	@Deprecated
	public boolean removeAll(Collection<?> c) {
		return super.removeAll(c);
	}

	@Override
	public String toString() {
		return String.format("size:%d", this.size());
	}

	// スタティックフィールド
	private static final long serialVersionUID = 8293487880322227008L;

	private static final IReadOnlyList<Object> _emptyReadOnlyList = new EnumerableList<>();

	// スタティックメソッド
	public static <T> EnumerableList<T> create(Iterable<T> collection) {
		return new EnumerableList<>(collection);
	}

	@SafeVarargs
	public static <T> EnumerableList<T> create(T... values) {
		return new EnumerableList<>(values);
	}

	public static <T> IReadOnlyList<T> getEmptyReadOnlyList() {
		IReadOnlyList<T> result = (IReadOnlyList<T>) EnumerableList._emptyReadOnlyList;
		return result;
	}
}
