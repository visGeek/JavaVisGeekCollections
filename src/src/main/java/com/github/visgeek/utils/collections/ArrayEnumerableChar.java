package com.github.visgeek.utils.collections;

import java.util.Iterator;

class ArrayEnumerableChar implements IListEnumerable<Character>, IEnumerable<Character> {
	// コンストラクター
	public ArrayEnumerableChar(char[] source) {
		this.source = source;
	}

	// フィールド
	private final char[] source;

	// メソッド
	@Override
	public Iterator<Character> iterator() {
		return new AbstractEnumerator<Character>() {
			private int index = -1;

			@Override
			public Character current() {
				return ArrayEnumerableChar.this.source[this.index];
			}

			@Override
			public boolean moveNext() {
				boolean result = false;

				this.index++;
				if (this.index < ArrayEnumerableChar.this.count()) {
					result = true;
				}

				return result;
			}
		};
	}

	@Override
	public Character elementAt(int index) {
		try {
			return this.source[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw Errors.argumentOfOutOfRange("index");
		}
	}

	@Override
	public int count() {
		return this.source.length;
	}

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
}
