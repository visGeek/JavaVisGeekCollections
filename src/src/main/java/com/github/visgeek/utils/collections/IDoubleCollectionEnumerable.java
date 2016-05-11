package com.github.visgeek.utils.collections;

public interface IDoubleCollectionEnumerable extends IDoubleEnumerable, ICollectionEnumerable<Double> {
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
