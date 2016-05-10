package com.github.visgeek.utils.collections;

import java.util.Comparator;

import com.github.visgeek.utils.ComparatorUtils;
import com.github.visgeek.utils.Func1;

public interface IOrderedEnumerable<T> extends IEnumerable<T> {
	Comparator<T> comparator();

	default <TKey extends Comparable<TKey>> IOrderedEnumerable<T> thenBy(Func1<? super T, TKey> keySelector) {
		Errors.throwIfNull(keySelector, "keySelector");

		Comparator<? super T> comparator = Comparator.comparing(keySelector::func);
		comparator = Comparator.nullsFirst(comparator); // null 優先

		return this.thenBy(comparator);
	}

	default <TKey> IOrderedEnumerable<T> thenBy(Func1<? super T, TKey> keySelector, Comparator<? super TKey> comparator) {
		Errors.throwIfNull(keySelector, "keySelector");

		if (comparator == null) {
			comparator = ComparatorUtils.getDefault();
		}

		return this.thenBy(Comparator.comparing(keySelector::func, comparator));
	}

	IOrderedEnumerable<T> thenBy(Comparator<? super T> comarator);

	default IOrderedEnumerable<T> thenByDefaultKey() {
		Comparator<T> comparator = ComparatorUtils.getDefault();
		return this.thenBy(comparator);
	}

	default IOrderedEnumerable<T> thenByDefaultKeyDescending() {
		Comparator<T> comparator = ComparatorUtils.getDefault();
		return this.thenByDescending(comparator);
	}

	default <TKey extends Comparable<TKey>> IOrderedEnumerable<T> thenByDescending(Func1<? super T, TKey> keySelector) {
		Errors.throwIfNull(keySelector, "keySelector");

		Comparator<? super T> comparator = Comparator.comparing(keySelector::func);
		comparator = Comparator.nullsFirst(comparator); // null 優先

		return this.thenByDescending(comparator);
	}

	default <TKey> IOrderedEnumerable<T> thenByDescending(Func1<? super T, TKey> keySelector, Comparator<? super TKey> comparator) {
		Errors.throwIfNull(keySelector, "keySelector");

		if (comparator == null) {
			comparator = ComparatorUtils.getDefault();
		}

		return this.thenByDescending(Comparator.comparing(keySelector::func, comparator));
	}

	IOrderedEnumerable<T> thenByDescending(Comparator<? super T> comarator);
}
