package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.github.visgeek.utils.Func0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.IndexedFunc0;

public final class Enumerable {
	// コンストラクター
	private Enumerable() {
	}

	// スタティックフィールド
	private static final IEnumerable<?> empty = () -> IEnumerator.empty();

	// スタティックメソッド
	@SafeVarargs
	public static <T> IEnumerable<T> of(T... source) {
		Errors.throwIfNull(source, "source");
		return new ReadOnlyList<>(Arrays.asList(source));
	}

	public static <T> IEnumerable<T> of(Iterable<T> source) {
		Errors.throwIfNull(source, "source");

		if (source instanceof IEnumerable<?>) {
			return (IEnumerable<T>) source;

		} else if (source instanceof List<?> && source instanceof RandomAccess) {
			return new ReadOnlyList<>((List<T>) source);

		} else if (source instanceof Collection<?>) {
			return new ReadOnlyCollection<>((Collection<T>) source);

		} else {
			return () -> source.iterator();
		}
	}

	public static <T> IEnumerable<T> of(Stream<T> source) {
		Errors.throwIfNull(source, "source");
		return () -> source.iterator();
	}

	public static IDoubleEnumerable of(double... source) {
		Errors.throwIfNull(source, "source");
		return new DoubleArray(source);
	}

	public static IDoubleEnumerable of(Double[] source) {
		Errors.throwIfNull(source, "source");
		return new ReadOnlyList.DoubleList(Arrays.asList(source));
	}

	public static IDoubleEnumerable ofDouble(Iterable<Double> source) {
		Errors.throwIfNull(source, "source");

		if (source instanceof IEnumerable<?>) {
			return ((IEnumerable<Double>) source).asDoubleEnumerable();

		} else if (source instanceof List<?> && source instanceof RandomAccess) {
			return new ReadOnlyList.DoubleList(((List<Double>) source));

		} else if (source instanceof Collection<?>) {
			return new ReadOnlyCollection.DoubleCollection((Collection<Double>) source);

		} else {
			return () -> source.iterator();
		}
	}

	public static IIntegerEnumerable of(int... source) {
		Errors.throwIfNull(source, "source");
		return new IntegerArray(source);
	}

	public static IIntegerEnumerable of(Integer[] source) {
		Errors.throwIfNull(source, "source");
		return new ReadOnlyList.IntegerList(Arrays.asList(source));
	}

	public static IIntegerEnumerable ofInteger(Iterable<Integer> source) {
		Errors.throwIfNull(source, "source");

		if (source instanceof IEnumerable<?>) {
			return ((IEnumerable<Integer>) source).asIntegerEnumerable();

		} else if (source instanceof List<?> && source instanceof RandomAccess) {
			return new ReadOnlyList.IntegerList((List<Integer>) source);

		} else if (source instanceof Collection<?>) {
			return new ReadOnlyCollection.IntegerCollection((Collection<Integer>) source);

		} else {
			return () -> source.iterator();
		}
	}

	public static ILongEnumerable of(long... source) {
		Errors.throwIfNull(source, "source");
		return new LongArray(source);
	}

	public static ILongEnumerable of(Long[] source) {
		Errors.throwIfNull(source, "source");
		return new ReadOnlyList.LongList(Arrays.asList(source));
	}

	public static ILongEnumerable ofLong(Iterable<Long> source) {
		Errors.throwIfNull(source, "source");

		if (source instanceof IEnumerable<?>) {
			return ((IEnumerable<Long>) source).asLongEnumerable();

		} else if (source instanceof List<?> && source instanceof RandomAccess) {
			return new ReadOnlyList.LongList((List<Long>) source);

		} else if (source instanceof Collection<?>) {
			return new ReadOnlyCollection.LongCollection((Collection<Long>) source);

		} else {
			return () -> source.iterator();
		}
	}

	public static ICharacterEnumerable of(char... source) {
		Errors.throwIfNull(source, "source");
		return new CharacterArray(source);
	}

	public static ICharacterEnumerable of(Character[] source) {
		Errors.throwIfNull(source, "source");
		return new ReadOnlyList.CharacterList(Arrays.asList(source));
	}

	public static ICharacterEnumerable ofCharacter(Iterable<Character> source) {
		Errors.throwIfNull(source, "source");

		if (source instanceof IEnumerable<?>) {
			return ((IEnumerable<Character>) source).asCharacterEnumerable();

		} else if (source instanceof List<?> && source instanceof RandomAccess) {
			return new ReadOnlyList.CharacterList((List<Character>) source);

		} else if (source instanceof Collection<?>) {
			return new ReadOnlyCollection.CharacterCollection((Collection<Character>) source);

		} else {
			return () -> source.iterator();
		}
	}

	public static ICharacterEnumerable ofCharacter(String source) {
		Errors.throwIfNull(source, "source");
		return Enumerable.of(source.toCharArray());
	}

	/**
	 * 空のシーケンスを取得します。
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> IEnumerable<T> empty() {
		return (IEnumerable<T>) Enumerable.empty;
	}

	/**
	 * 空のシーケンスを取得します。
	 * @return
	 */
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
			return new IntegerSequence.IntegerEnumerable(start, end);
		}
	}

	/**
	 * 指定した範囲の整数をセレクター関数で変換した結果のシーケンスを取得します。
	 * @param start
	 * @param end
	 * @return
	 */
	public static <T> IEnumerable<T> forTo(int start, int end, IndexedFunc0<? extends T> selector) {
		if (end < start) {
			throw Errors.argumentOfOutOfRange("end");
		}

		Errors.throwIfNull(selector, "selector");

		return new IntegerSequence<T>(start, end, selector);
	}

	/**
	 * for ステートメントと同様の操作で要素を列挙します。
	 * @param first 最初の要素、または null。
	 * @param predicate 列挙を続けるための条件、または null。
	 * @param next 要素を列挙したあとに実行する処理 または null。
	 * @return
	 */
	public static <T> IEnumerable<T> forTo(Func0<? extends T> first, Predicate<? super T> predicate, Func1<? super T, ? extends T> next) {
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
	 * 指定した範囲の整数をセレクター関数で変換した結果のシーケンスを取得します。
	 * @param start
	 * @param end
	 * @return
	 */
	public static <T> IEnumerable<T> range(int start, int count, IndexedFunc0<? extends T> selector) {
		int end = Enumerable.rangeParameterCheck(start, count);
		Errors.throwIfNull(selector, "selector");
		return new IntegerSequence<T>(start, end, selector);
	}

	/**
	 * start から始まる count の数の連続した整数のシーケンスを作成します。作成されたシーケンスはランダムアクセスをサポートします。
	 * @param start
	 * @param count
	 * @return
	 */
	public static IIntegerEnumerable range2(int start, int count) {
		int end = Enumerable.rangeParameterCheck(start, count);
		return new IntegerSequence.IntegerEnumerable(start, end);
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

		return Enumerable.range(0, count, n -> element);
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

		return new IntegerSequence.RepeatEnumerable<>(count, element);
	}
}
