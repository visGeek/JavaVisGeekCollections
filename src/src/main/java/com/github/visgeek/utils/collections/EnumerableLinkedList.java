package com.github.visgeek.utils.collections;

import java.util.Collection;

@SuppressWarnings("unchecked")
public class EnumerableLinkedList<T> extends java.util.LinkedList<T> implements IList<T> {
	// コンストラクター
	public EnumerableLinkedList() {
		super();
	}

	public EnumerableLinkedList(Collection<? extends T> collection) {
		super(collection);
	}

	public EnumerableLinkedList(Iterable<? extends T> collection) {
		this();
		this.addAll(collection);
	}

	@SafeVarargs
	public EnumerableLinkedList(T... values) {
		for (T value : values) {
			this.add(value);
		}
	}

	// フィールド

	// メソッド
	@Override
	public EnumerableLinkedList<T> clone() {
		return new EnumerableLinkedList<>(this);
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
	public boolean removeFirstOccurrence(Object o) {
		return super.removeFirstOccurrence(o);
	}

	/**
	 * removeFirstOccurrence(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	public boolean removeFirstOccurredValue(T o) {
		return super.removeFirstOccurrence(o);
	}

	@Override
	@Deprecated
	public boolean removeLastOccurrence(Object o) {
		return super.removeLastOccurrence(o);
	}

	/**
	 * removeLastOccurrence(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	public boolean removeLastOccurredValue(T o) {
		return super.removeLastOccurrence(o);
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
	private static final long serialVersionUID = -2806056720008680671L;

	private static final IReadOnlyList<Object> _emptyReadOnlyList = new EnumerableLinkedList<>();

	// スタティックメソッド
	public static <T> EnumerableLinkedList<T> create(Iterable<T> collection) {
		return new EnumerableLinkedList<>(collection);
	}

	@SafeVarargs
	public static <T> EnumerableLinkedList<T> create(T... values) {
		return new EnumerableLinkedList<>(values);
	}

	public static <T> IReadOnlyList<T> getEmptyReadOnlyList() {
		IReadOnlyList<T> result = (IReadOnlyList<T>) EnumerableLinkedList._emptyReadOnlyList;
		return result;
	}
}
