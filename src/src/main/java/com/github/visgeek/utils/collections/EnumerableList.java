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
		if (collection instanceof Collection<?>) {
			@SuppressWarnings("unchecked")
			Collection<T> c = (Collection<T>) collection;
			this.addAll(c);
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
	public boolean addAll(Iterable<? extends T> c) {
		return this.addAll(this.size(), c);
	}

	public boolean addAll(int index, Iterable<? extends T> c) {
		boolean result = false;

		if (c instanceof Collection<?>) {
			@SuppressWarnings("unchecked")
			Collection<T> vals = (Collection<T>) c;
			result = this.addAll(index, vals);
		} else {
			int idx = index;
			for (T item : c) {
				this.add(idx, item);
				idx++;
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

	public boolean removeAllValues(Iterable<? extends T> c) {
		boolean result = false;

		if (c instanceof Collection<?>) {
			@SuppressWarnings("unchecked")
			Collection<T> vals = (Collection<T>) c;
			result = super.removeAll(vals);
		} else {
			for (T item : c) {
				while (this.removeValue(item)) {
					result = true;
				}
			}
		}

		return result;
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
		@SuppressWarnings("unchecked")
		IReadOnlyList<T> result = (IReadOnlyList<T>) EnumerableList._emptyReadOnlyList;
		return result;
	}
}
