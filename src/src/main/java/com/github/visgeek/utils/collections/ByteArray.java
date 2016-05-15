package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Iterator;

class ByteArray implements IReadOnlyList<Byte>, IByteCollection {
	// コンストラクター
	public ByteArray(byte[] source) {
		this.source = source;
	}

	// フィールド
	private final byte[] source;

	// メソッド
	@Override
	public boolean contains(Byte item) {
		boolean result = false;

		if (item != null) {
			byte primitive = item;
			for (byte val : this.source) {
				if (val == primitive) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	@Override
	public Byte get(int index) {
		try {
			return this.source[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw Errors.argumentOfOutOfRange("index");
		}
	}

	@Override
	public Iterator<Byte> iterator() {
		return new AbstractEnumerator<Byte>() {
			private int index = -1;

			@Override
			public Byte current() {
				return ByteArray.this.source[this.index];
			}

			@Override
			public boolean moveNext() {
				boolean result = false;

				this.index++;
				if (this.index < ByteArray.this.count()) {
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
	public byte[] toPrimitiveArray() {
		byte[] array = Arrays.copyOf(this.source, this.count());
		return array;
	}
}
