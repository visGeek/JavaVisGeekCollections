package com.github.visgeek.utils.collections;

interface ICharacterCollection extends ICharacterEnumerable, IReadOnlyCollection<Character> {
	@Override
	default char[] toPrimitiveArray() {
		char[] array = new char[this.count()];

		int i = 0;
		for (Character value : this) {
			array[i] = value == null ? 0 : value;
			i++;
		}

		return array;
	}
}
