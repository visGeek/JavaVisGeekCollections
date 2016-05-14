package com.github.visgeek.utils.collections;

import com.github.visgeek.utils.Func0;

public interface IReadOnlyList<T> extends IReadOnlyCollection<T> {
	@Override
	default T elementAt(int index) {
		try {
			return this.get(index);
		} catch (IndexOutOfBoundsException e) {
			throw Errors.argumentOfOutOfRange("index");
		}
	}

	@Override
	default T elementAtOrDefault(int index, Func0<T> defaultValue) {
		if (0 <= index && index < this.count()) {
			return this.elementAt(index);
		} else {
			return defaultValue.func();
		}
	}

	@Override
	default T first() {
		if (this.any()) {
			return this.elementAt(0);
		} else {
			throw Errors.empty();
		}
	}

	@Override
	default T firstOrDefault(T defaultValue) {
		if (this.any()) {
			return this.first();
		} else {
			return defaultValue;
		}
	}

	T get(int index);

	@Override
	default T last() {
		if (this.any()) {
			return this.elementAt(this.count() - 1);
		} else {
			throw Errors.empty();
		}
	}

	@Override
	default T lastOrDefault(T defaultValue) {
		if (this.any()) {
			return this.last();
		} else {
			return defaultValue;
		}
	}

	@Override
	default IEnumerable<T> reverse() {
		return Enumerable.range(0, this.count()).select(idx -> this.elementAt(this.count() - idx - 1));
	}

	@Override
	default T single() {
		switch (this.count()) {
			case 1:
				return this.first();

			case 0:
				throw Errors.empty();

			default:
				throw Errors.moreThanOneElement();
		}
	}

	@Override
	default T singleOrDefault(T defaultValue) {
		if (this.count() == 1) {
			return this.first();
		} else {
			return defaultValue;
		}
	}
}
