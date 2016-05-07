package com.github.visgeek.utils.collections;

import java.util.Collection;
import java.util.List;

class CollectionEnumerableInteger extends CollectionEnumerable<Integer> implements IIntegerEnumerable {
	// コンストラクター
	CollectionEnumerableInteger(List<Integer> source) {
		super(source);
	}

	CollectionEnumerableInteger(Collection<Integer> source) {
		super(source);
	}
}
