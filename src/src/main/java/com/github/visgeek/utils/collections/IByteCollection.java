package com.github.visgeek.utils.collections;

interface IByteCollection extends IByteEnumerable, IReadOnlyCollection<Byte> {
	@Override
	default byte[] toPrimitiveArray() {
		byte[] array = new byte[this.count()];

		int i = 0;
		for (Byte value : this) {
			array[i] = value == null ? 0 : value;
			i++;
		}

		return array;
	}
}
