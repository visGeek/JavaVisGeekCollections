package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Iterator;

class PrimitiveFloatArray implements IReadOnlyList<Float>, IFloatCollection {
	// コンストラクター
	public PrimitiveFloatArray(float[] source) {
		this.source = source;
	}

	// フィールド
	private final float[] source;

	// メソッド
	@Override
	public boolean contains(Float item) {
		boolean result = false;

		if (item != null) {
			float primitive = item;
			for (float val : this.source) {
				if (val == primitive) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	@Override
	public Float get(int index) {
		try {
			return this.source[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw Errors.argumentOfOutOfRange("index");
		}
	}

	@Override
	public Iterator<Float> iterator() {
		return new AbstractEnumerator<Float>() {
			private int index = -1;

			@Override
			public Float current() {
				return PrimitiveFloatArray.this.source[this.index];
			}

			@Override
			public boolean moveNext() {
				boolean result = false;

				this.index++;
				if (this.index < PrimitiveFloatArray.this.count()) {
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
	public float[] toPrimitiveArray() {
		float[] array = Arrays.copyOf(this.source, this.count());
		return array;
	}
}
