package com.github.visgeek.utils.collections;

import com.github.visgeek.utils.Func0;

interface IListEnumerable<T> extends ICollectionEnumerable<T> {
	@Override
	T elementAt(int index);

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
		return this.any() ? this.first() : defaultValue;
	}

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
		T value = defaultValue;

		if (this.any()) {
			value = this.last();
		}

		return value;
	}

	@Override
	default IEnumerable<T> reverse() {
		return Enumerable.range(0, this.count()).select(idx -> this.elementAt(this.count() - idx - 1));
	}

	@Override
	default T single() {
		if (this.count() == 1) {
			return this.first();
		} else {
			throw Errors.moreThanOneElement();
		}
	}
}
