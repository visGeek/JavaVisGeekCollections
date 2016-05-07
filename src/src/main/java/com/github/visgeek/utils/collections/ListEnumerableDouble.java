package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.List;

class ListEnumerableDouble extends ListEnumerable<Double> implements IDoubleEnumerable {
	// コンストラクター
	ListEnumerableDouble(List<Double> source) {
		super(source);
	}

	@SafeVarargs
	ListEnumerableDouble(Double... source) {
		super(Arrays.asList(source));
	}
}
