package jp.visgeek.utils.collections;

import java.util.Comparator;

import jp.visgeek.utils.Func1;

public interface IOrderedEnumerable<T> extends IEnumerable<T> {
	Comparator<T> comparator();

	default <TKey extends Comparable<TKey>> IOrderedEnumerable<T> thenBy(Func1<? super T, TKey> keySelector) {
		Errors.throwIfNull(keySelector, "keySelector");
		return this.thenBy(Comparator.comparing(keySelector::func));
	}

	default <TKey> IOrderedEnumerable<T> thenBy(Func1<? super T, TKey> keySelector, Comparator<? super TKey> comparator) {
		Errors.throwIfNull(keySelector, "keySelector");
		Errors.throwIfNull(comparator, "comparator");
		return this.thenBy(Comparator.comparing(keySelector::func, comparator));
	}

	IOrderedEnumerable<T> thenBy(Comparator<? super T> comarator);

	default IOrderedEnumerable<T> thenByDefaultKey() {
		Comparator<T> comparator =
				new Comparator<T>() {
					@Override
					public int compare(T arg0, T arg1) {
						@SuppressWarnings("unchecked")
						Comparable<T> a = (Comparable<T>) arg0;

						return a.compareTo(arg1);
					}
				};

		return this.thenBy(comparator);
	}

	default IOrderedEnumerable<T> thenByDefaultKeyDescending() {
		Comparator<T> comparator =
				new Comparator<T>() {
					@Override
					public int compare(T arg0, T arg1) {
						@SuppressWarnings("unchecked")
						Comparable<T> a = (Comparable<T>) arg0;

						return a.compareTo(arg1);
					}
				};

		return this.thenByDescending(comparator);
	}

	default <TKey extends Comparable<TKey>> IOrderedEnumerable<T> thenByDescending(Func1<? super T, TKey> keySelector) {
		Errors.throwIfNull(keySelector, "keySelector");
		return this.thenByDescending(Comparator.comparing(keySelector::func));
	}

	default <TKey> IOrderedEnumerable<T> thenByDescending(Func1<? super T, TKey> keySelector, Comparator<? super TKey> comparator) {
		Errors.throwIfNull(keySelector, "keySelector");
		Errors.throwIfNull(comparator, "comparator");
		return this.thenByDescending(Comparator.comparing(keySelector::func, comparator));
	}

	IOrderedEnumerable<T> thenByDescending(Comparator<? super T> comarator);
}
