package com.github.visgeek.utils.collections;

import java.util.List;

public interface ILongEnumerable extends IEnumerable<Long> {
	default long average() {
		long sum = 0;
		long cnt = 0;

		for (Long item : this) {
			if (item != null) {
				sum += item;
				cnt++;
			}
		}

		return sum / (long) cnt;
	}

	default long sum() {
		long sum = 0;

		for (Long item : this) {
			if (item != null) {
				sum += item;
			}
		}

		return sum;
	}

	default long[] toPrimitiveArray() {
		List<?> list = this.toList();

		long[] array = new long[list.size()];

		int i = 0;
		for (Long value : this) {
			array[i] = value == null ? 0 : value;
			i++;
		}

		return array;
	}
}
