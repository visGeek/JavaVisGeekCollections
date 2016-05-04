package com.github.visgeek.utils.collections;

import java.util.List;

public interface IDoubleEnumerable extends IEnumerable<Double> {
	default double average() {
		double sum = 0;
		long cnt = 0;

		for (Double item : this) {
			if (item != null) {
				sum += item;
				cnt++;
			}
		}

		return sum / (double) cnt;
	}

	default double sum() {
		double sum = 0;

		for (Double item : this) {
			if (item != null) {
				sum += item;
			}
		}

		return sum;
	}

	@SuppressWarnings("unchecked")
	default double[] toArray() {
		List<Double> list;
		if (this instanceof List<?>) {
			list = (List<Double>) this;
		} else {
			list = this.toList();
		}

		double[] array = new double[list.size()];
		int i = 0;
		for (Double value : list) {
			array[i] = value;
			i++;
		}

		return array;
	}
}
