package com.github.visgeek.utils.collections;

import java.util.Collection;
import java.util.Collections;

class ReadOnlyCollection<T> extends ReadOnlyCollectionBase<T, Collection<T>> {
	// コンストラクター
	ReadOnlyCollection(Collection<T> collection) {
		super(Collections.unmodifiableCollection(collection));
	}

	// Double
	static class DoubleCollection extends ReadOnlyCollection<Double> implements IDoubleCollection {
		DoubleCollection(Collection<Double> source) {
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

	// Byte
	static class ByteCollection extends ReadOnlyCollection<Byte> implements IByteCollection {
		ByteCollection(Collection<Byte> source) {
			super(source);
		}
	}

	// Character
	static class CharacterCollection extends ReadOnlyCollection<Character> implements ICharacterCollection {
		CharacterCollection(Collection<Character> source) {
			super(source);
		}
	}
}
