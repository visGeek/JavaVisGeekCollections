package com.github.visgeek.utils.collections;

import java.util.Collection;
import java.util.List;

class CollectionEnumerableDouble extends CollectionEnumerable<Double> implements IDoubleEnumerable {
	// コンストラクター
	CollectionEnumerableDouble(List<Double> source) {
		super(source);
	}

	CollectionEnumerableDouble(Collection<Double> source) {
		super(source);
	}
}
