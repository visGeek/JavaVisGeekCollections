package com.github.visgeek.utils.collections;

import java.util.Arrays;

class ArrayEnumerableDouble extends ArrayEnumerable<Double> implements IDoubleCollectionEnumerable {
	// コンストラクター
	public ArrayEnumerableDouble(double[] source) {
		this.source = source;
	}

	// フィールド
	private final double[] source;

	// メソッド
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
