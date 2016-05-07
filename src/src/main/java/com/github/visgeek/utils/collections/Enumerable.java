package com.github.visgeek.utils.collections;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import com.github.visgeek.utils.Func0;
import com.github.visgeek.utils.Func1;

public final class Enumerable {
	// コンストラクター
	private Enumerable() {
	}

	// スタティックメソッド
	@SafeVarargs
	public static <T> IEnumerable<T> of(T... source) {
		return new ListEnumerable<>(source);
	}

	public static <T> IEnumerable<T> of(Iterable<T> source) {
		if (source instanceof List<?>) {
			return new ListEnumerable<T>(((List<T>) source));
		} else if (source instanceof Collection<?>) {
			return new CollectionEnumerable<T>(((Collection<T>) source));
		} else {
			return () -> source.iterator();
		}
	}

	public static <T> IEnumerable<T> of(Stream<T> source) {
		return () -> source.iterator();
	}

	public static IIntegerEnumerable of(int[] source) {
		return () -> new ArrayEnumeratorInt(source);
	}

	public static IIntegerEnumerable of(Integer... source) {
		return new ListEnumerableInteger(source);
	}

	public static IIntegerEnumerable ofInteger(Iterable<Integer> source) {
		if (source instanceof List<?>) {
			return new ListEnumerableInteger(((List<Integer>) source));
		} else if (source instanceof Collection<?>) {
			return new CollectionEnumerableInteger(((Collection<Integer>) source));
		} else {
			return () -> source.iterator();
		}
	}

	public static ILongEnumerable of(long[] source) {
		return () -> new ArrayEnumeratorLong(source);
	}

	public static ILongEnumerable of(Long... source) {
		return new ListEnumerableLong(source);
	}

	public static ILongEnumerable ofLong(Iterable<Long> source) {
		if (source instanceof List<?>) {
			return new ListEnumerableLong(((List<Long>) source));
		} else if (source instanceof Collection<?>) {
			return new CollectionEnumerableLong(((Collection<Long>) source));
		} else {
			return () -> source.iterator();
		}
	}

	public static IDoubleEnumerable of(double[] source) {
		return () -> new ArrayEnumeratorDouble(source);
	}

	public static IDoubleEnumerable of(Double... source) {
		return new ListEnumerableDouble(source);
	}

	public static IDoubleEnumerable ofDouble(Iterable<Double> source) {
		if (source instanceof List<?>) {
			return new ListEnumerableDouble(((List<Double>) source));
		} else if (source instanceof Collection<?>) {
			return new CollectionEnumerableDouble(((Collection<Double>) source));
		} else {
			return () -> source.iterator();
		}
	}

	public static IEnumerable<Character> of(char[] source) {
		return () -> new ArrayEnumeratorChar(source);
	}

	public static IEnumerable<Character> of(String source) {
		return Enumerable.of(source.toCharArray());
	}

	public static <T> IEnumerable<T> empty() {
		return () -> IEnumerator.create(null, val -> false, null);
	}

	public static <T> IEnumerable<T> empty(Class<T> elementClass) {
		return Enumerable.<T> empty();
	}

	public static IEnumerable<Integer> forTo(int start, int finish) {
		return () -> IEnumerator.create(() -> start, n -> n <= finish, n -> n + 1);
	}

	public static <T> IEnumerable<T> forTo(Func0<? extends T> first, Func1<? super T, Boolean> predicate, Func1<? super T, ? extends T> next) {
		return () -> IEnumerator.create(first, predicate, next);
	}

	public static IEnumerable<Integer> range(int start, int count) {
		return () -> new LinqRangeEnumerator(start, count);
	}

	public static <T> IEnumerable<T> repeat(final T element, int count) {
		return Enumerable.range(0, count).select(n -> element);
	}
}
