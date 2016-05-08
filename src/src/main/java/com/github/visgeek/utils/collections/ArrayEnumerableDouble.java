package com.github.visgeek.utils.collections;

class ArrayEnumerableDouble extends ArrayEnumerable<Double> implements IDoubleEnumerable {
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
			throw Errors.ArgumentOfOutOfRange("index");
		}
	}

	@Override
	public int count() {
		return this.source.length;
	}

	@Override
	public boolean contains(Double item) {
		boolean result = false;

		for (double val : this.source) {
			if (val == item) {
				result = true;
				break;
			}
		}

		return result;
	}
}
