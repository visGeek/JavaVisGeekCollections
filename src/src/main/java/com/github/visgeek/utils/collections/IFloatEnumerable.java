package com.github.visgeek.utils.collections;

import java.util.List;

public interface IFloatEnumerable extends IEnumerable<Float> {
	/**
	 * null 以外の値の平均値を取得します。
	 * @return null 以外の値の平均値。シーケンスが空、または null のみの場合は null。
	 */
	default Float average() {
		double sum = 0.0;
		long cnt = 0;

		for (Float value : this) {
			if (value != null) {
				sum += value;
				cnt++;
			}
		}

		if (cnt == 0) {
			return null;
		} else {
			return (float) (sum / cnt);
		}
	}

	/**
	 * null 以外の値の合計値を取得します。
	 * @return
	 */
	default float sum() {
		double sum = 0.0;

		for (Float value : this) {
			if (value != null) {
				sum += value;
			}
		}

		return (float) sum;
	}

	/**
	 * 要素をコピーした新しい float 型の配列を取得します。null は 0 として扱います。
	 * @return
	 */
	default float[] toPrimitiveArray() {
		List<Float> list = this.toList();

		float[] array = new float[list.size()];

		int i = -1;
		for (Float value : list) {
			i++;
			if (value != null) {
				array[i] = value;
			}
		}

		return array;
	}
}
