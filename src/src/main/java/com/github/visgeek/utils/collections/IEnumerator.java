package com.github.visgeek.utils.collections;

import java.util.Iterator;
import java.util.function.Predicate;

import com.github.visgeek.utils.functions.Func0;
import com.github.visgeek.utils.functions.Func1;

public interface IEnumerator<T> extends Iterator<T> {
	// メソッド
	@Override
	@Deprecated
	T next();

	@Override
	@Deprecated
	boolean hasNext();

	T current();

	boolean moveNext();

	default IEnumerable<T> toEnumerableRemaining() {
		return () -> IEnumerator.this;
	}

	// スタティックフィールド
	static final IEnumerator<?> empty = IEnumerator.create(null, val -> false, null);

	@SuppressWarnings("unchecked")
	public static <T> IEnumerator<T> empty() {
		return (IEnumerator<T>) IEnumerator.empty;
	}

	// スタティックメソッド
	static <T> IEnumerator<T> create(Func0<? extends T> first, Predicate<? super T> predicate, Func1<? super T, ? extends T> next) {
		return new Enumerator<T>() {
			private boolean initial = true;

			private T current = null;

			@Override
			public T current() {
				return this.current;
			}

			@Override
			public boolean moveNext() {
				if (this.initial) { // 最初
					this.current = (first == null) ? null : first.func();
					this.initial = false;

				} else if (next != null) { // 2回目以降
					this.current = next.func(this.current);
				}

				// 条件
				boolean result = (predicate == null) ? true : predicate.test(this.current);
				return result;
			}
		};
	}
}
