package com.github.visgeek.utils.collections;

interface ICharacterCollectionEnumerable extends ICharacterEnumerable, ICollectionEnumerable<Character> {
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
