package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.List;

class ListEnumerableCharacter extends ListEnumerable<Character> implements ICharacterCollectionEnumerable {
	// コンストラクター
	ListEnumerableCharacter(List<Character> source) {
		super(source);
	}

	@SafeVarargs
	ListEnumerableCharacter(Character... source) {
		super(Arrays.asList(source));
	}
}
