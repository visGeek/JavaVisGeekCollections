package com.github.visgeek.utils.collections;

import java.util.List;

public interface ICharacterEnumerable extends IEnumerable<Character> {
	/**
	 * 要素をコピーした新しい char 型の配列を取得します。null は '\0' として扱います。
	 * @return
	 */
	default char[] toPrimitiveArray() {
		List<Character> list = this.toList();

		char[] array = new char[list.size()];

		int i = -1;
		for (Character value : list) {
			i++;
			if (value != null) {
				array[i] = value;
			}
		}

		return array;
	}
}
