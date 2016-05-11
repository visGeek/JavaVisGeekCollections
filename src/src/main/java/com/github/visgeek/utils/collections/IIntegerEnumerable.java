package com.github.visgeek.utils.collections;

import java.util.List;

public interface IIntegerEnumerable extends IEnumerable<Integer> {
	default double average() {
		long sum = 0;
		long cnt = 0;

		for (Integer item : this) {
			if (item != null) {
				sum += item;
				cnt++;
			}
		}

		return (double) sum / (double) cnt;
	}

	default int sum() {
		int sum = 0;

		for (Integer item : this) {
			if (item != null) {
				sum += item;
			}
		}

		return sum;
	}

	default int[] toPrimitiveArray() {
		List<Integer> list = this.toList();

		int[] array = new int[list.size()];

		int i = 0;
		for (Integer value : list) {
			array[i] = value == null ? 0 : value;
			i++;
		}

		return array;
	}
}
