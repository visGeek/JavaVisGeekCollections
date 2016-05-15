package com.github.visgeek.utils.collections;

import java.util.List;

public interface IBooleanEnumerable extends IEnumerable<Boolean> {
	/**
	 * 要素をコピーした新しい boolean 型の配列を取得します。null は false として扱います。
	 * @return
	 */
	default boolean[] toPrimitiveArray() {
		List<Boolean> list = this.toList();

		boolean[] array = new boolean[list.size()];

		int i = -1;
		for (Boolean value : list) {
			i++;
			if (value != null) {
				array[i] = value;
			}
		}

		return array;
	}
}
