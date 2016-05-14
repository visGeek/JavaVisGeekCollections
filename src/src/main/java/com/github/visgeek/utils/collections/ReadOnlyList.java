package com.github.visgeek.utils.collections;

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

	// Double
	static class DoubleList extends ReadOnlyList<Double> implements IDoubleCollection {
		DoubleList(List<Double> source) {
			super(source);
		}
	}

	// Character
	static class CharacterList extends ReadOnlyList<Character> implements ICharacterCollection {
		CharacterList(List<Character> source) {
			super(source);
		}
	}
}
