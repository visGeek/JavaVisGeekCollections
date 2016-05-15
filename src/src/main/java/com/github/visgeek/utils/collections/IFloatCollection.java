package com.github.visgeek.utils.collections;

interface IFloatCollection extends IFloatEnumerable, IReadOnlyCollection<Float> {
	@Override
	default float[] toPrimitiveArray() {
		float[] array = new float[this.count()];

		int i = 0;
		for (Float value : this) {
			array[i] = value == null ? 0 : value;
			i++;
		}

		return array;
	}
}
