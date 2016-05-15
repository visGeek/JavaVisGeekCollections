package com.github.visgeek.utils.collections;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

class ReadOnlyList<T> extends ReadOnlyCollectionBase<T, List<T>> implements IReadOnlyList<T> {
	// コンストラクター
	ReadOnlyList(List<T> source) {
		super(Collections.unmodifiableList(source));
	}

	// メソッド
	@Override
	public T get(int index) {
		return this.source.get(index);
	}

	// Byte
	static class ByteList extends ReadOnlyList<Byte> implements IByteCollection {
		ByteList(List<Byte> source) {
			super(source);
		}
	}

	// Short
	static class ShortList extends ReadOnlyList<Short> implements IShortCollection {
		ShortList(List<Short> source) {
			super(source);
		}
	}

	// Integer
	static class IntegerList extends ReadOnlyList<Integer> implements IIntegerCollection {
		IntegerList(List<Integer> source) {
			super(source);
		}
	}

	// Long
	static class LongList extends ReadOnlyList<Long> implements ILongCollection {
		LongList(List<Long> source) {
			super(source);
		}
	}

	// Float
	static class FloatList extends ReadOnlyList<Float> implements IFloatCollection {
		FloatList(List<Float> source) {
			super(source);
		}
	}

	// Double
	static class DoubleList extends ReadOnlyList<Double> implements IDoubleCollection {
		DoubleList(List<Double> source) {
			super(source);
		}
	}

	// Boolean
	static class BooleanList extends ReadOnlyList<Boolean> implements IBooleanCollection {
		BooleanList(List<Boolean> source) {
			super(source);
		}
	}

	// Character
	static class CharacterList extends ReadOnlyList<Character> implements ICharacterCollection {
		CharacterList(List<Character> source) {
			super(source);
		}
	}

	// BigDecimal
	static class BigDecimalList extends ReadOnlyList<BigDecimal> implements IBigDecimalCollection {
		BigDecimalList(List<BigDecimal> source) {
			super(source);
		}
	}
}
