package com.github.visgeek.utils.collections.test.testcase.collection.map.ireadonlymap;

import java.util.ArrayList;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.collections.IReadOnlyMap;
import com.github.visgeek.utils.testing.Assert2;

public class Cast {
	@Test
	public void cast() {
		EnumerableMap<Integer, ArrayList<String>> map = new EnumerableMap<>();

		Action0 action = () -> {
			@SuppressWarnings("unused")
			IReadOnlyMap<Integer, Iterable<String>> map2 = IReadOnlyMap.cast(map);
		};

		Assert2.assertExceptionNotThrown(action);
	}
}
