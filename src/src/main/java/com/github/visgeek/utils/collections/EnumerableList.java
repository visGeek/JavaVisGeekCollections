package com.github.visgeek.utils.collections;

import java.util.Collection;

public class EnumerableList<T> extends java.util.ArrayList<T> implements IReadOnlyList<T> {
	// コンストラクター
	public EnumerableList() {
		super();
	}

	public EnumerableList(Collection<? extends T> collection) {
		super(collection);
	}

	public EnumerableList(Iterable<? extends T> collection) {
		this();
		this.addAll(collection);
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
	public final void addAll(Iterable<? extends T> c) {
		this.addAll(this.size(), c);
	}

	public boolean addAll(int index, Iterable<? extends T> c) {
		boolean result = false;

		if (c instanceof Collection<?>) {
			@SuppressWarnings("unchecked")
			Collection<T> vals = (Collection<T>) c;
			result = this.addAll(vals);
		} else {
			for (T item : c) {
				this.add(item);
				result = true;
			}
		}

		return result;
	}

	@Override
	public boolean any() {
		return !this.isEmpty();
	}

	@Override
	public EnumerableList<T> clone() {
		return new EnumerableList<>(this);
	}

	@Override
	@Deprecated
	public boolean contains(Object o) {
		return super.contains(o);
	}

	/**
	 * contains(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	public boolean containsValue(T o) {
		return super.contains(o);
	}

	@Override
	@Deprecated
	public int indexOf(Object o) {
		return super.indexOf(o);
	}

	/**
	 * indexOf(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	public int indexOfValue(T o) {
		return super.indexOf(o);
	}

	@Override
	@Deprecated
	public int lastIndexOf(Object o) {
		return super.lastIndexOf(o);
	}

	/**
	 * lastIndexOf(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	public int lastIndexOfValue(T o) {
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

	/**
	 * remove(int index) と同じ動作です。
	 * @param index
	 * @return
	 */
	public T removeAt(int index) {
		return super.remove(index);
	}

	/**
	 * remove(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	public boolean removeValue(T o) {
		return super.remove(o);
	}

	@Override
	@Deprecated
	public boolean removeAll(Collection<?> c) {
		return super.removeAll(c);
	}

	public boolean removeAll(Iterable<? extends T> c) {
		boolean result = false;

		if (c instanceof Collection<?>) {
			@SuppressWarnings("unchecked")
			Collection<T> vals = (Collection<T>) c;
			result = super.removeAll(vals);
		} else {
			result = super.removeAll(new EnumerableList<>(c));
		}

		return result;
	}

	@Override
	@SuppressWarnings("hiding")
	public <T> T[] toArray(T[] a) {
		return super.toArray(a);
	}

	@Override
	public String toString() {
		return String.format("size:%d", this.size());
	}

	// スタティックフィールド
	private static final long serialVersionUID = 8293487880322227008L;

	public static final IReadOnlyList<Object> _emptyReadOnlyList = new EnumerableList<>();

	// スタティックメソッド
	public static <T> EnumerableList<T> create(Iterable<T> collection) {
		return new EnumerableList<T>(collection);
	}

	@SafeVarargs
	public static <T> EnumerableList<T> create(T... values) {
		return new EnumerableList<T>(values);
	}

	public static <T> IReadOnlyList<T> getEmptyReadOnlyList() {
		@SuppressWarnings("unchecked")
		IReadOnlyList<T> result = (IReadOnlyList<T>) EnumerableList._emptyReadOnlyList;
		return result;
	}
}
