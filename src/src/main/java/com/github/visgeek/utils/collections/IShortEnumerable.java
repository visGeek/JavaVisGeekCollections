package com.github.visgeek.utils.collections;

import java.util.List;

public interface IShortEnumerable extends IEnumerable<Short> {
	/**
	 * null 以外の値の平均値を取得します。
	 * @return null 以外の値の平均値。シーケンスが空、または null のみの場合は null。
	 */
	default Double average() {
		long sum = 0;
		long cnt = 0;

		for (Short value : this) {
			if (value != null) {
				sum = Math.addExact(sum, value);
				cnt++;
			}
		}

		if (cnt == 0) {
			return null;
		} else {
			return (double) sum / cnt;
		}
	}

	/**
	 * null 以外の値の合計値を取得します。戻り値は int 型です。
	 * @return
	 */
	default int sum() {
		int sum = 0;

		for (Short value : this) {
			if (value != null) {
				sum = Math.addExact(sum, value);
			}
		}

		return sum;
	}

	/**
	 * 要素をコピーした新しい short 型の配列を取得します。null は 0 として扱います。
	 * @return
	 */
	default short[] toPrimitiveArray() {
		List<Short> list = this.toList();

		short[] array = new short[list.size()];

		int i = -1;
		for (Short value : list) {
			i++;
			if (value != null) {
				array[i] = value;
			}
		}

		return array;
	}
}
