package com.github.visgeek.utils.collections;

import java.util.List;

public interface IIntegerEnumerable extends IEnumerable<Integer> {
	/**
	 * null 以外の値の平均値を取得します。
	 * @return null 以外の値の平均値。シーケンスが空、または null のみの場合は null。
	 */
	default Double average() {
		long sum = 0;
		long cnt = 0;

		for (Integer value : this) {
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
	 * null 以外の値の合計値を取得します。
	 * @return
	 */
	default int sum() {
		int sum = 0;

		for (Integer value : this) {
			if (value != null) {
				sum = Math.addExact(sum, value);
			}
		}

		return sum;
	}

	/**
	 * 要素をコピーした新しい int 型の配列を取得します。null は 0 として扱います。
	 * @return
	 */
	default int[] toPrimitiveArray() {
		List<Integer> list = this.toList();

		int[] array = new int[list.size()];

		int i = -1;
		for (Integer value : list) {
			i++;
			if (value != null) {
				array[i] = value;
			}
		}

		return array;
	}
}
