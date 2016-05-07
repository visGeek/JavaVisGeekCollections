package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

class ListEnumerable<T> extends CollectionEnumerable<T> implements List<T> {
	// コンストラクター
	ListEnumerable(List<T> source) {
		super(source);
	}

	@SafeVarargs
	ListEnumerable(T... source) {
		super(Arrays.asList(source));
	}

	// フィールド

	// メソッド
	@Override
	List<T> source() {
		return (List<T>) super.source();
	}

	//////////////// IEnumerable<T>

	//////////////// List<T>
	@Override
	public boolean addAll(int paramInt, Collection<? extends T> paramCollection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T get(int paramInt) {
		return this.source().get(paramInt);
	}

	@Override
	public T set(int paramInt, T paramE) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int paramInt, T paramE) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T remove(int paramInt) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int indexOf(Object paramObject) {
		return this.source().indexOf(paramObject);
	}

	@Override
	public int lastIndexOf(Object paramObject) {
		return this.lastIndexOf(paramObject);
	}

	@Override
	public ListIterator<T> listIterator() {
		return this.source().listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int paramInt) {
		return this.source().listIterator(paramInt);
	}

	@Override
	public List<T> subList(int paramInt1, int paramInt2) {
		return this.source().subList(paramInt1, paramInt2);
	}
}
