package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Iterator;

class ArrayEnumerableDouble implements IListEnumerable<Double>, IDoubleCollectionEnumerable {
	// コンストラクター
	public ArrayEnumerableDouble(double[] source) {
		this.source = source;
	}

	// フィールド
	private final double[] source;

	// メソッド
	@Override
	public Iterator<Double> iterator() {
		return new AbstractEnumerator<Double>() {
			private int index = -1;

			@Override
			public Double current() {
				return ArrayEnumerableDouble.this.source[this.index];
			}

			@Override
			public boolean moveNext() {
				boolean result = false;

				this.index++;
				if (this.index < ArrayEnumerableDouble.this.count()) {
					result = true;
				}

				return result;
			}
		};
	}

	@Override
	public Double elementAt(int index) {
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
	public double[] toPrimitiveArray() {
		double[] array = Arrays.copyOf(this.source, this.count());
		return array;
	}
}
