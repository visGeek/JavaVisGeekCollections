package com.github.visgeek.utils.collections;

import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
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
		if (source instanceof IEnumerable<?>) {
			return (IEnumerable<T>) source;
		} else if (source instanceof List<?> && source instanceof RandomAccess) {
			return new ListEnumerable<>((List<T>) source);
		} else if (source instanceof Collection<?>) {
			return new CollectionEnumerable<>((Collection<T>) source);
		} else {
			return () -> source.iterator();
		}
	}

	public static <T> IEnumerable<T> of(Stream<T> source) {
		return () -> source.iterator();
	}

	public static IDoubleEnumerable of(double[] source) {
		return new ArrayEnumerableDouble(source);
	}

	public static IDoubleEnumerable of(Double... source) {
		return new ListEnumerableDouble(source);
	}

	public static IDoubleEnumerable ofDouble(Iterable<Double> source) {
		if (source instanceof IEnumerable<?>) {
			return ((IEnumerable<Double>) source).asDoubleEnumerable();
		} else if (source instanceof List<?> && source instanceof RandomAccess) {
			return new ListEnumerableDouble(((List<Double>) source));
		} else if (source instanceof Collection<?>) {
			return new CollectionEnumerableDouble((Collection<Double>) source);
		} else {
			return () -> source.iterator();
		}
	}

	public static IIntegerEnumerable of(int[] source) {
		return new ArrayEnumerableInt(source);
	}

	public static IIntegerEnumerable of(Integer... source) {
		return new ListEnumerableInteger(source);
	}

	public static IIntegerEnumerable ofInteger(Iterable<Integer> source) {
		if (source instanceof IEnumerable<?>) {
			return ((IEnumerable<Integer>) source).asIntegerEnumerable();
		} else if (source instanceof List<?> && source instanceof RandomAccess) {
			return new ListEnumerableInteger((List<Integer>) source);
		} else if (source instanceof Collection<?>) {
			return new CollectionEnumerableInteger((Collection<Integer>) source);
		} else {
			return () -> source.iterator();
		}
	}

	public static ILongEnumerable of(long[] source) {
		return new ArrayEnumerableLong(source);
	}

	public static ILongEnumerable of(Long... source) {
		return new ListEnumerableLong(source);
	}

	public static ILongEnumerable ofLong(Iterable<Long> source) {
		if (source instanceof IEnumerable<?>) {
			return ((IEnumerable<Long>) source).asLongEnumerable();
		} else if (source instanceof List<?> && source instanceof RandomAccess) {
			return new ListEnumerableLong((List<Long>) source);
		} else if (source instanceof Collection<?>) {
			return new CollectionEnumerableLong((Collection<Long>) source);
		} else {
			return () -> source.iterator();
		}
	}

	public static IEnumerable<Character> of(char[] source) {
		return new ArrayEnumerableChar(source);
	}

	public static IEnumerable<Character> ofCharacter(String source) {
		return Enumerable.of(source.toCharArray());
	}

	public static <T> IEnumerable<T> empty() {
		return () -> IEnumerator.create(null, val -> false, null);
	}

	public static <T> IEnumerable<T> empty(Class<T> elementClass) {
		return Enumerable.<T> empty();
	}

	/**
	 * start から end までの連続する整数のシーケンスを作成します。作成されたシーケンスはランダムアクセスをサポートします。
	 * @param start
	 * @param end
	 * @return
	 */
	public static IIntegerEnumerable forTo(int start, int end) {
		if (end < start) {
			throw Errors.argumentOfOutOfRange("end");
		} else {
			return new IntegerSequenceEnumerable(start, end);
		}
	}

	public static <T> IEnumerable<T> forTo(Func0<? extends T> first, Func1<? super T, Boolean> predicate, Func1<? super T, ? extends T> next) {
		return () -> IEnumerator.create(first, predicate, next);
	}

	/**
	 * start から始まる count の数の連続した整数のシーケンスを作成します。
	 * @param start
	 * @param count
	 * @return
	 */
	public static IIntegerEnumerable range(int start, int count) {
		Enumerable.rangeParameterCheck(start, count);
		return () -> new LinqRangeEnumerator(start, count);
	}

	/**
	 * start から始まる count の数の連続した整数のシーケンスを作成します。作成されたシーケンスはランダムアクセスをサポートします。
	 * @param start
	 * @param count
	 * @return
	 */
	public static IIntegerEnumerable range2(int start, int count) {
		int end = Enumerable.rangeParameterCheck(start, count);
		return new IntegerSequenceEnumerable(start, end);
	}

	private static int rangeParameterCheck(int start, int count) {
		if (count < 0) {
			throw Errors.argumentOfOutOfRange("count");
		}

		long end = ((long) start) + count - 1;
		if (Integer.MAX_VALUE < end) {
			throw Errors.argumentOfOutOfRange("count");
		}

		return (int) end;
	}

	/**
	 * element を count の数だけ含むシーケンスを作成します。
	 * @param element
	 * @param count
	 * @return
	 */
	public static <T> IEnumerable<T> repeat(T element, int count) {
		if (count < 0) {
			throw Errors.argumentOfOutOfRange("count");
		}

		return Enumerable.range(0, count).select(n -> element);
	}

	/**
	 * element を count の数だけ含むシーケンスを作成します。作成されたシーケンスはランダムアクセスをサポートします。
	 * @param element
	 * @param count
	 * @return
	 */
	public static <T> IEnumerable<T> repeat2(T element, int count) {
		if (count < 0) {
			throw Errors.argumentOfOutOfRange("count");
		}

		return new RepeatEnumerable<>(element, count);
	}
}
