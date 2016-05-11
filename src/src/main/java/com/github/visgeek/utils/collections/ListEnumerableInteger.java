package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.List;

class ListEnumerableInteger extends ListEnumerable<Integer> implements IIntegerCollectionEnumerable {
	// コンストラクター
	ListEnumerableInteger(List<Integer> source) {
		super(source);
	}

	@SafeVarargs
	ListEnumerableInteger(Integer... source) {
		super(Arrays.asList(source));
	}
}
