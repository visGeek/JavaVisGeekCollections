package com.github.visgeek.utils.test;

import java.util.ArrayList;
import java.util.List;

class Functions {
	@SafeVarargs
	public static void addTo(List<Integer> values, int... valueArray) {
		for (int value : valueArray) {
			values.add(value);
		}
	}

	@SafeVarargs
	public static void addToOrThrow(List<Integer> values, int... valueArray) throws NullPointerException {
		if (values == null) {
			throw new NullPointerException();
		} else {
			Functions.addTo(values, valueArray);
		}
	}

	@SafeVarargs
	public static List<Integer> toList(int... valueArray) {
		List<Integer> result = new ArrayList<>();

		for (int value : valueArray) {
			result.add(value);
		}

		return result;
	}

	@SafeVarargs
	public static List<Integer> toListOrThrow(boolean throwException, int... valueArray) throws NullPointerException {
		if (throwException) {
			throw new NullPointerException();
		} else {
			return Functions.toList(valueArray);
		}
	}
}
