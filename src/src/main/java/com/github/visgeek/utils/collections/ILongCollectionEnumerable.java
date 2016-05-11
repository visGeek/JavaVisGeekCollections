package com.github.visgeek.utils.collections;

interface ILongCollectionEnumerable extends ILongEnumerable, ICollectionEnumerable<Long> {
	@Override
	default long[] toPrimitiveArray() {
		long[] array = new long[this.count()];

		int i = 0;
		for (Long value : this) {
			array[i] = value == null ? 0 : value;
			i++;
		}

		return array;
	}
}
