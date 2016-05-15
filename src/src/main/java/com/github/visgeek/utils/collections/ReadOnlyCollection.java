package com.github.visgeek.utils.collections;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;

class ReadOnlyCollection<T> extends ReadOnlyCollectionBase<T, Collection<T>> {
	// コンストラクター
	ReadOnlyCollection(Collection<T> collection) {
		super(Collections.unmodifiableCollection(collection));
	}

	// Byte
	static class ByteCollection extends ReadOnlyCollection<Byte> implements IByteCollection {
		ByteCollection(Collection<Byte> source) {
			super(source);
		}
	}

	// Short
	static class ShortCollection extends ReadOnlyCollection<Short> implements IShortCollection {
		ShortCollection(Collection<Short> source) {
			super(source);
		}
	}

	// Integer
	static class IntegerCollection extends ReadOnlyCollection<Integer> implements IIntegerCollection {
		IntegerCollection(Collection<Integer> source) {
			super(source);
		}
	}

	// Long
	static class LongCollection extends ReadOnlyCollection<Long> implements ILongCollection {
		LongCollection(Collection<Long> source) {
			super(source);
		}
	}

	// Float
	static class FloatCollection extends ReadOnlyCollection<Float> implements IFloatCollection {
		FloatCollection(Collection<Float> source) {
			super(source);
		}
	}

	// Double
	static class DoubleCollection extends ReadOnlyCollection<Double> implements IDoubleCollection {
		DoubleCollection(Collection<Double> source) {
			super(source);
		}
	}

	// Boolean
	static class BooleanCollection extends ReadOnlyCollection<Boolean> implements IBooleanCollection {
		BooleanCollection(Collection<Boolean> source) {
			super(source);
		}
	}

	// Character
	static class CharacterCollection extends ReadOnlyCollection<Character> implements ICharacterCollection {
		CharacterCollection(Collection<Character> source) {
			super(source);
		}
	}

	// BigDecimal
	static class BigDecimalCollection extends ReadOnlyCollection<BigDecimal> implements IBigDecimalCollection {
		BigDecimalCollection(Collection<BigDecimal> source) {
			super(source);
		}
	}
}
