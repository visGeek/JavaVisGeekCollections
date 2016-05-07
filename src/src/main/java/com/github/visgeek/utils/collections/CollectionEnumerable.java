package com.github.visgeek.utils.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

class CollectionEnumerable<T> implements IEnumerable<T>, Collection<T> {
	// コンストラクター
	CollectionEnumerable(List<T> source) {
		this._source = Collections.unmodifiableList(source);
	}

	CollectionEnumerable(Collection<T> source) {
		this._source = Collections.unmodifiableCollection(source);
	}

	// フィールド
	private final Collection<T> _source;

	// メソッド
	Collection<T> source() {
		return this._source;
	}

	@Override
	public final Iterator<T> iterator() {
		return this.source().iterator();
	}

	//////////////// IEnumerable<T>
	@Override
	public final boolean any() {
		return !this.isEmpty();
	}

	@Override
	public final int count() {
		return this.source().size();
	}

	//////////////// Collection<T>
	@Override
	public final int size() {
		return this.source().size();
	}

	@Override
	public final boolean isEmpty() {
		return this.source().isEmpty();
	}

	@Override
	public final void forEach(Consumer<? super T> paramConsumer) {
		this.source().forEach(paramConsumer);
	}

	@Override
	public final boolean contains(Object paramObject) {
		return this.source().contains(paramObject);
	}

	@Override
	public final Object[] toArray() {
		return this.source().toArray();
	}

	@Override
	@SuppressWarnings("hiding")
	public final <T> T[] toArray(T[] paramArrayOfT) {
		return this.source().toArray(paramArrayOfT);
	}

	@Override
	public final boolean add(T paramE) {
		throw new UnsupportedOperationException();
	}

	@Override
	public final boolean remove(Object paramObject) {
		throw new UnsupportedOperationException();
	}

	@Override
	public final boolean containsAll(Collection<?> paramCollection) {
		return this.source().containsAll(paramCollection);
	}

	@Override
	public final boolean addAll(Collection<? extends T> paramCollection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public final boolean removeAll(Collection<?> paramCollection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public final boolean removeIf(Predicate<? super T> paramPredicate) {
		throw new UnsupportedOperationException();
	}

	@Override
	public final boolean retainAll(Collection<?> paramCollection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public final void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public final boolean equals(Object paramObject) {
		return this.source().equals(paramObject);
	}

	@Override
	public final int hashCode() {
		return this.source().hashCode();
	}

	@Override
	public final Spliterator<T> spliterator() {
		return this.source().spliterator();
	}

	@Override
	public final Stream<T> stream() {
		return this.source().stream();
	}

	@Override
	public final Stream<T> parallelStream() {
		return this.source().parallelStream();
	}
}
