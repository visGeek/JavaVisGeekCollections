package com.github.visgeek.utils.collections;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.github.visgeek.utils.Func0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.IndexedFunc0;
import com.github.visgeek.utils.collections.test.testcase.enumerable.of.IBigDecimalEnumerable;

public final class Enumerable {
	// コンストラクター
	private Enumerable() {
	}

	// スタティックフィールド
	private static final IEnumerable<?> empty = () -> IEnumerator.empty();

	// スタティックメソッド
	// Object
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

	// Stream
	public static <T> IEnumerable<T> of(Stream<T> source) {
		Errors.throwIfNull(source, "source");
		return () -> source.iterator();
	}

	// int
	public static IIntegerEnumerable of(int... source) {
		Errors.throwIfNull(source, "source");
		return new PrimitiveIntegerArray(source);
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

	// short
	public static IShortEnumerable of(short... source) {
		Errors.throwIfNull(source, "source");
		return new PrimitiveShortArray(source);
	}

	public static IShortEnumerable of(Short[] source) {
		Errors.throwIfNull(source, "source");
		return new ReadOnlyList.ShortList(Arrays.asList(source));
	}

	public static IShortEnumerable ofShort(Iterable<Short> source) {
		Errors.throwIfNull(source, "source");

		if (source instanceof IEnumerable<?>) {
			return ((IEnumerable<Short>) source).asShortEnumerable();

		} else if (source instanceof List<?> && source instanceof RandomAccess) {
			return new ReadOnlyList.ShortList((List<Short>) source);

		} else if (source instanceof Collection<?>) {
			return new ReadOnlyCollection.ShortCollection((Collection<Short>) source);

		} else {
			return () -> source.iterator();
		}
	}

	// long
	public static ILongEnumerable of(long... source) {
		Errors.throwIfNull(source, "source");
		return new PrimitiveLongArray(source);
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

	// byte
	public static IByteEnumerable of(byte... source) {
		Errors.throwIfNull(source, "source");
		return new PrimitiveByteArray(source);
	}

	public static IByteEnumerable of(Byte[] source) {
		Errors.throwIfNull(source, "source");
		return new ReadOnlyList.ByteList(Arrays.asList(source));
	}

	public static IByteEnumerable ofByte(Iterable<Byte> source) {
		Errors.throwIfNull(source, "source");

		if (source instanceof IEnumerable<?>) {
			return ((IEnumerable<Byte>) source).asByteEnumerable();

		} else if (source instanceof List<?> && source instanceof RandomAccess) {
			return new ReadOnlyList.ByteList((List<Byte>) source);

		} else if (source instanceof Collection<?>) {
			return new ReadOnlyCollection.ByteCollection((Collection<Byte>) source);

		} else {
			return () -> source.iterator();
		}
	}

	// float
	public static IFloatEnumerable of(float... source) {
		Errors.throwIfNull(source, "source");
		return new PrimitiveFloatArray(source);
	}

	public static IFloatEnumerable of(Float[] source) {
		Errors.throwIfNull(source, "source");
		return new ReadOnlyList.FloatList(Arrays.asList(source));
	}

	public static IFloatEnumerable ofFloat(Iterable<Float> source) {
		Errors.throwIfNull(source, "source");

		if (source instanceof IEnumerable<?>) {
			return ((IEnumerable<Float>) source).asFloatEnumerable();

		} else if (source instanceof List<?> && source instanceof RandomAccess) {
			return new ReadOnlyList.FloatList(((List<Float>) source));

		} else if (source instanceof Collection<?>) {
			return new ReadOnlyCollection.FloatCollection((Collection<Float>) source);

		} else {
			return () -> source.iterator();
		}
	}

	// double
	public static IDoubleEnumerable of(double... source) {
		Errors.throwIfNull(source, "source");
		return new PrimitiveDoubleArray(source);
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

	// boolean
	public static IBooleanEnumerable of(boolean... source) {
		Errors.throwIfNull(source, "source");
		return new PrimitiveBooleanArray(source);
	}

	public static IBooleanEnumerable of(Boolean[] source) {
		Errors.throwIfNull(source, "source");
		return new ReadOnlyList.BooleanList(Arrays.asList(source));
	}

	public static IBooleanEnumerable ofBoolean(Iterable<Boolean> source) {
		Errors.throwIfNull(source, "source");

		if (source instanceof IEnumerable<?>) {
			return ((IEnumerable<Boolean>) source).asBooleanEnumerable();

		} else if (source instanceof List<?> && source instanceof RandomAccess) {
			return new ReadOnlyList.BooleanList((List<Boolean>) source);

		} else if (source instanceof Collection<?>) {
			return new ReadOnlyCollection.BooleanCollection((Collection<Boolean>) source);

		} else {
			return () -> source.iterator();
		}
	}

	// char
	public static ICharacterEnumerable of(char... source) {
		Errors.throwIfNull(source, "source");
		return new PrimitiveCharacterArray(source);
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

	// BigDecimal
	public static IBigDecimalEnumerable of(BigDecimal... source) {
		Errors.throwIfNull(source, "source");
		return new ReadOnlyList.BigDecimalList(Arrays.asList(source));
	}

	public static IBigDecimalEnumerable ofBigDecimal(Iterable<BigDecimal> source) {
		Errors.throwIfNull(source, "source");

		if (source instanceof IEnumerable<?>) {
			return ((IEnumerable<BigDecimal>) source).asBigDecimalEnumerable();

		} else if (source instanceof List<?> && source instanceof RandomAccess) {
			return new ReadOnlyList.BigDecimalList((List<BigDecimal>) source);

		} else if (source instanceof Collection<?>) {
			return new ReadOnlyCollection.BigDecimalCollection((Collection<BigDecimal>) source);

		} else {
			return () -> source.iterator();
		}
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
