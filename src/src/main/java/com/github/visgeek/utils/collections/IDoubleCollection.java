package com.github.visgeek.utils.collections;

interface IDoubleCollection extends IDoubleEnumerable, IReadOnlyCollection<Double> {
	@Override
	default double[] toPrimitiveArray() {
		double[] array = new double[this.count()];

		int i = 0;
		for (Double value : this) {
			array[i] = value == null ? 0 : value;
			i++;
		}

		return array;
	}
}
