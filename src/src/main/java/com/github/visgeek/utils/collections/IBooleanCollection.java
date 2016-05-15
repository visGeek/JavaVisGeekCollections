package com.github.visgeek.utils.collections;

interface IBooleanCollection extends IBooleanEnumerable, IReadOnlyCollection<Boolean> {
	@Override
	default boolean[] toPrimitiveArray() {
		boolean[] array = new boolean[this.count()];

		int i = 0;
		for (Boolean value : this) {
			array[i] = value == null ? false : value;
			i++;
		}

		return array;
	}
}
