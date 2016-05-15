package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Iterator;

class PrimitiveCharacterArray implements IReadOnlyList<Character>, ICharacterCollection {
	// コンストラクター
	public PrimitiveCharacterArray(char[] source) {
		this.source = source;
	}

	// フィールド
	private final char[] source;

	// メソッド
	@Override
	public boolean contains(Character item) {
		boolean result = false;

		if (item != null) {
			char primitive = item;
			for (char val : this.source) {
				if (val == primitive) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	@Override
	public Character get(int index) {
		try {
			return this.source[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw Errors.argumentOfOutOfRange("index");
		}
	}

	@Override
	public Iterator<Character> iterator() {
		return new AbstractEnumerator<Character>() {
			private int index = -1;

			@Override
			public Character current() {
				return PrimitiveCharacterArray.this.source[this.index];
			}

			@Override
			public boolean moveNext() {
				boolean result = false;

				this.index++;
				if (this.index < PrimitiveCharacterArray.this.count()) {
					result = true;
				}

				return result;
			}
		};
	}

	@Override
	public int size() {
		return this.source.length;
	}

	@Override
	public char[] toPrimitiveArray() {
		char[] array = Arrays.copyOf(this.source, this.count());
		return array;
	}
}
