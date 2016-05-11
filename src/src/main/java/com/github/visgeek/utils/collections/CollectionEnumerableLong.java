package com.github.visgeek.utils.collections;

import java.util.Collection;

class CollectionEnumerableLong extends CollectionEnumerable<Long> implements ILongCollectionEnumerable {
	// コンストラクター
	CollectionEnumerableLong(Collection<Long> source) {
		super(source);
	}
}
