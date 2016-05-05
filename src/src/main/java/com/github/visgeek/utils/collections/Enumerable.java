package com.github.visgeek.utils.collections;

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
		return () -> new ArrayEnumerator<>(source);
	}

	public static <T> IEnumerable<T> of(Iterable<T> source) {
		return () -> source.iterator();
	}

	public static <T> IEnumerable<T> of(Stream<T> source) {
		return () -> source.iterator();
	}

	public static IIntegerEnumerable ofInteger(int[] source) {
		return () -> new ArrayEnumeratorInt(source);
	}

	public static IIntegerEnumerable ofInteger(Integer... source) {
		return () -> new ArrayEnumerator<>(source);
	}

	public static IIntegerEnumerable ofInteger(Iterable<Integer> source) {
		return () -> source.iterator();
	}

	public static ILongEnumerable ofLong(long[] source) {
		return () -> new ArrayEnumeratorLong(source);
	}

	public static ILongEnumerable ofLong(Long... source) {
		return () -> new ArrayEnumerator<>(source);
	}

	public static ILongEnumerable ofLong(Iterable<Long> source) {
		return () -> source.iterator();
	}

	public static IDoubleEnumerable ofDouble(double[] source) {
		return () -> new ArrayEnumeratorDouble(source);
	}

	public static IDoubleEnumerable ofDouble(Double... source) {
		return () -> new ArrayEnumerator<>(source);
	}

	public static IDoubleEnumerable ofDouble(Iterable<Double> source) {
		return () -> source.iterator();
	}

	public static IEnumerable<Character> ofCharacter(char[] source) {
		return () -> new ArrayEnumeratorChar(source);
	}

	public static IEnumerable<Character> ofCharacter(String source) {
		return Enumerable.ofCharacter(source.toCharArray());
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
