package com.github.visgeek.utils.collections;

import java.util.List;

public interface IDoubleEnumerable extends IEnumerable<Double> {
	/**
	 * null 以外の値の平均値を取得します。
	 * @return null 以外の値の平均値。シーケンスが空、または null のみの場合は null。
	 */
	default Double average() {
		double sum = 0;
		long cnt = 0;

		for (Double value : this) {
			if (value != null) {
				sum += value;
				cnt++;
			}
		}

		if (cnt == 0) {
			return null;
		} else {
			return sum / cnt;
		}
	}

	/**
	 * null 以外の値の合計値を取得します。
	 * @return
	 */
	default double sum() {
		double sum = 0;

		for (Double value : this) {
			if (value != null) {
				sum += value;
			}
		}

		return sum;
	}

	/**
	 * 要素をコピーした新しい double 型の配列を取得します。null は 0 として扱います。
	 * @return
	 */
	default double[] toPrimitiveArray() {
		List<Double> list = this.toList();

		double[] array = new double[list.size()];

		int i = -1;
		for (Double value : list) {
			i++;
			if (value != null) {
				array[i] = value;
			}
		}

		return array;
	}

	@Override
	default Double max() {
		Double result = null;

		for (Double item : this) {
			if (item != null) {
				if (result == null) {
					result = item;
				} else if (result < item) {
					result = item;
				} else if (Double.isNaN(result)) {
					result = item;
				}
			}
		}

		return result;
	}

	@Override
	default Double min() {
		Double result = null;

		for (Double item : this) {
			if (item != null) {
				if (result == null) {
					result = item;
				} else if (item < result) {
					result = item;
				} else if (Double.isNaN(item)) {
					result = item;
				}
			}
		}

		return result;
	}
}
