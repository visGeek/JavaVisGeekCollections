package com.github.visgeek.utils.collections;

import java.util.List;

public interface IByteEnumerable extends IEnumerable<Byte> {
	/**
	 * 要素をコピーした新しい byte 型の配列を取得します。null は 0 として扱います。
	 * @return
	 */
	default byte[] toPrimitiveArray() {
		List<Byte> list = this.toList();

		byte[] array = new byte[list.size()];

		int i = -1;
		for (Byte value : list) {
			i++;
			if (value != null) {
				array[i] = value;
			}
		}

		return array;
	}
}
