package com.github.visgeek.utils.collections.test.testcase.readonlycollection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
class ItemCollection {
	public static <T> Collection<T> createCollection(T... values) {
		return new CollectionImple<>(values);
	}

	/**
	 * テスト用<br/>
	 * List&lt;E&gt; を被っていない純粋な Collection&lt;E&gt;
	 *
	 */
	private static class CollectionImple<T> implements Collection<T> {
		CollectionImple(T... values) {
			this.values = Arrays.asList(values);
		}

		private final Collection<T> values;

		@Override
		public void forEach(Consumer<? super T> action) {
			this.values.forEach(action);
		}

		@Override
		public int size() {
			return this.values.size();
		}

		@Override
		public boolean isEmpty() {
			return this.values.isEmpty();
		}

		@Override
		public boolean contains(Object o) {
			return this.values.contains(o);
		}

		@Override
		public Iterator<T> iterator() {
			return this.values.iterator();
		}

		@Override
		public Object[] toArray() {
			return this.values.toArray();
		}

		@Override
		@SuppressWarnings("hiding")
		public <T> T[] toArray(T[] a) {
			return this.values.toArray(a);
		}

		@Override
		public boolean add(T e) {
			return this.values.add(e);
		}

		@Override
		public boolean remove(Object o) {
			return this.values.remove(o);
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return this.values.containsAll(c);
		}

		@Override
		public boolean addAll(Collection<? extends T> c) {
			return this.values.addAll(c);
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			return this.values.removeAll(c);
		}

		@Override
		public boolean removeIf(Predicate<? super T> filter) {
			return this.values.removeIf(filter);
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			return this.values.retainAll(c);
		}

		@Override
		public void clear() {
			this.values.clear();
		}

		@Override
		public boolean equals(Object o) {
			return this.values.equals(o);
		}

		@Override
		public int hashCode() {
			return this.values.hashCode();
		}

		@Override
		public Spliterator<T> spliterator() {
			return this.values.spliterator();
		}

		@Override
		public Stream<T> stream() {
			return this.values.stream();
		}

		@Override
		public Stream<T> parallelStream() {
			return this.values.parallelStream();
		}
	}
}
