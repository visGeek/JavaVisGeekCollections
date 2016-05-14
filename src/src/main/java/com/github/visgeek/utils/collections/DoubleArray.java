package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Iterator;

class DoubleArray implements IReadOnlyList<Double>, IDoubleCollection {
	// コンストラクター
	public DoubleArray(double[] source) {
		this.source = source;
	}

	// フィールド
	private final double[] source;

	// メソッド
	@Override
	public boolean contains(Double item) {
		boolean result = false;

		if (item != null) {
			double primitive = item;
			for (double val : this.source) {
				if (val == primitive) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	@Override
	public Double get(int index) {
		try {
			return this.source[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw Errors.argumentOfOutOfRange("index");
		}
	}

	@Override
	public Iterator<Double> iterator() {
		return new AbstractEnumerator<Double>() {
			private int index = -1;

			@Override
			public Double current() {
				return DoubleArray.this.source[this.index];
			}

			@Override
			public boolean moveNext() {
				boolean result = false;

				this.index++;
				if (this.index < DoubleArray.this.count()) {
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
	public double[] toPrimitiveArray() {
		double[] array = Arrays.copyOf(this.source, this.count());
		return array;
	}
}
