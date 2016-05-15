package com.github.visgeek.utils.collections;

interface IShortCollection extends IShortEnumerable, IReadOnlyCollection<Short> {
	@Override
	default short[] toPrimitiveArray() {
		short[] array = new short[this.count()];

		int i = 0;
		for (Short value : this) {
			array[i] = value == null ? 0 : value;
			i++;
		}

		return array;
	}
}
