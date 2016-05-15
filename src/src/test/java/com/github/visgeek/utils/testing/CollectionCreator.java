package com.github.visgeek.utils.testing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.github.visgeek.utils.collections.IEnumerable;

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

	public static <T> Collection<T> collection(T... values) {
		return new CollectionImple<>(values);
	}

	public static <T> Iterable<T> iterable(T... values) {
		return () -> Arrays.asList(values).iterator();
	}

	public static <T> Iterator<T> iterator(T... values) {
		return Arrays.asList(values).iterator();
	}

	public static <T> LinkedList<T> linkedList(T... values) {
		return new LinkedList<>(Arrays.asList(values));
	}

	public static boolean[] primitiveArray(Boolean... values) {
		boolean[] result = new boolean[values.length];

		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				result[i] = values[i];
			}
		}

		return result;
	}

	public static byte[] primitiveArray(Byte... values) {
		byte[] result = new byte[values.length];

		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				result[i] = values[i];
			}
		}

		return result;
	}

	public static char[] primitiveArray(Character... values) {
		char[] result = new char[values.length];

		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				result[i] = values[i];
			}
		}

		return result;
	}

	public static double[] primitiveArray(Double... values) {
		double[] result = new double[values.length];

		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				result[i] = values[i];
			}
		}

		return result;
	}

	public static float[] primitiveArray(Float... values) {
		float[] result = new float[values.length];

		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				result[i] = values[i];
			}
		}

		return result;
	}

	public static int[] primitiveArray(Integer... values) {
		int[] result = new int[values.length];

		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				result[i] = values[i];
			}
		}

		return result;
	}

	public static long[] primitiveArray(Long... values) {
		long[] result = new long[values.length];

		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				result[i] = values[i];
			}
		}

		return result;
	}

	public static short[] primitiveArray(Short... values) {
		short[] result = new short[values.length];

		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				result[i] = values[i];
			}
		}

		return result;
	}

	public static Boolean[] objectArray(boolean... values) {
		Boolean[] result = new Boolean[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = values[i];
		}

		return result;
	}

	public static Byte[] objectArray(byte... values) {
		Byte[] result = new Byte[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = values[i];
		}

		return result;
	}

	public static Character[] objectArray(char... values) {
		Character[] result = new Character[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = values[i];
		}

		return result;
	}

	public static Double[] objectArray(double... values) {
		Double[] result = new Double[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = values[i];
		}

		return result;
	}

	public static Float[] objectArray(float... values) {
		Float[] result = new Float[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = values[i];
		}

		return result;
	}

	public static Integer[] objectArray(int... values) {
		Integer[] result = new Integer[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = values[i];
		}

		return result;
	}

	public static Long[] objectArray(long... values) {
		Long[] result = new Long[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = values[i];
		}

		return result;
	}

	public static Short[] objectArray(short... values) {
		Short[] result = new Short[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = values[i];
		}

		return result;
	}

	@SafeVarargs
	public static <T> T[] emptyAarray(T... values) {
		return CollectionCreator.emptyArray((Class<T[]>) values.getClass());
	}

	public static <T> T[] emptyArray(Class<T[]> arrayClass) {
		T[] result = (T[]) Array.newInstance(arrayClass.getComponentType(), 0);
		return result;
	}

	public static <T> IEnumerable<T> enumerable(T... values) {
		return () -> CollectionCreator.iterator(values);
	}

	private static class CollectionImple<T> implements Collection<T> {
		CollectionImple(T... values) {
			this.values = Arrays.asList(values);
		}

		private final Collection<T> values;

		@Override
		public boolean add(T e) {
			return this.values.add(e);
		}

		@Override
		public boolean addAll(Collection<? extends T> c) {
			return this.values.addAll(c);
		}

		@Override
		public void clear() {
			this.values.clear();
		}

		@Override
		public boolean contains(Object o) {
			return this.values.contains(o);
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return this.values.containsAll(c);
		}

		@Override
		public boolean equals(Object o) {
			return this.values.equals(o);
		}

		@Override
		public void forEach(Consumer<? super T> action) {
			this.values.forEach(action);
		}

		@Override
		public int hashCode() {
			return this.values.hashCode();
		}

		@Override
		public boolean isEmpty() {
			return this.values.isEmpty();
		}

		@Override
		public Iterator<T> iterator() {
			return this.values.iterator();
		}

		@Override
		public Stream<T> parallelStream() {
			return this.values.parallelStream();
		}

		@Override
		public boolean remove(Object o) {
			return this.values.remove(o);
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
		public int size() {
			return this.values.size();
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
		public Object[] toArray() {
			return this.values.toArray();
		}

		@Override
		@SuppressWarnings("hiding")
		public <T> T[] toArray(T[] a) {
			return this.values.toArray(a);
		}
	}
}
