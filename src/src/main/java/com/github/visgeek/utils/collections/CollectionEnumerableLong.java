package com.github.visgeek.utils.collections;

import java.util.Collection;
import java.util.List;

class CollectionEnumerableLong extends CollectionEnumerable<Long> implements ILongEnumerable {
	// コンストラクター
	CollectionEnumerableLong(List<Long> source) {
		super(source);
	}

	CollectionEnumerableLong(Collection<Long> source) {
		super(source);
	}
}
