package com.github.visgeek.utils.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * テスト用<br/>
 * List&lt;E&gt; を被っていない純粋な Collection&lt;E&gt;
 *
 */
@SuppressWarnings("unchecked")
public class CollectionCreator {
	public static <T> ArrayList<T> arrayList(T... values) {
		return new ArrayList<>(Arrays.asList(values));
	}

	public static <T> LinkedList<T> linkedList(T... values) {
		return new LinkedList<>(Arrays.asList(values));
	}

	public static <T> Iterable<T> iterable(T... values) {
		return () -> Arrays.asList(values).iterator();
	}

	public static <T> Iterator<T> iterator(T... values) {
		return Arrays.asList(values).iterator();
	}

	public static <T> Collection<T> collection(T... values) {
		return new CollectionImple<>(values);
	}

	public static byte[] primitiveArray(Byte... values) {
		byte[] result = new byte[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = values[i];
		}

		return result;
	}

	public static char[] primitiveArray(Character... values) {
		char[] result = new char[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = values[i];
		}

		return result;
	}

	public static double[] primitiveArray(Double... values) {
		double[] result = new double[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = values[i];
		}

		return result;
	}

	public static int[] primitiveArray(Integer... values) {
		int[] result = new int[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = values[i];
		}

		return result;
	}

	public static long[] primitiveArray(Long... values) {
		long[] result = new long[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = values[i];
		}

		return result;
	}

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
