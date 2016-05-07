package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.List;

class ListEnumerableLong extends ListEnumerable<Long> implements ILongEnumerable {
	// コンストラクター
	ListEnumerableLong(List<Long> source) {
		super(source);
	}

	@SafeVarargs
	ListEnumerableLong(Long... source) {
		super(Arrays.asList(source));
	}
}
