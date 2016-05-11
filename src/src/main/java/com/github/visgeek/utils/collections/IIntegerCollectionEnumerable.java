package com.github.visgeek.utils.collections;

public interface IIntegerCollectionEnumerable extends IIntegerEnumerable, ICollectionEnumerable<Integer> {
	@Override
	default int[] toPrimitiveArray() {
		int[] array = new int[this.count()];

		int i = 0;
		for (Integer value : this) {
			array[i] = value == null ? 0 : value;
			i++;
		}

		return array;
	}
}
