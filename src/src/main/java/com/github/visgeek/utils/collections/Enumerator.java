package com.github.visgeek.utils.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import com.github.visgeek.utils.functions.Func0;
import com.github.visgeek.utils.functions.Func1;

/**
 * current() と moveNext() を使ったイテレーションを行うための抽象クラスです。Iterator&lt;T&gt; のメソッドと IEnumerator&lt;T&gt; のメソッドをあわせて実行した場合の動作は保証されません。
 * @param <T>
 */
@SuppressWarnings("unchecked")
public abstract class Enumerator<T> implements Iterator<T> {
	// コンストラクター
	public Enumerator() {
	}

	// フィールド
	private boolean isMoved = false;

	private boolean hasNext;

	// メソッド
	public abstract T current();

	public abstract boolean moveNext();

	/**
	 * @deprecated 使用禁止
	 * @return
	 */
	@Deprecated
	@Override
	public final boolean hasNext() {
		if (!this.isMoved) {
			this.hasNext = this.moveNext();
			this.isMoved = true;
		}

		return this.hasNext;
	}

	/**
	 * @deprecated 使用禁止
	 * @return
	 */
	@Deprecated
	@Override
	public final T next() {
		T current;

		if (this.isMoved) {
			current = this.current();
			this.isMoved = false;

		} else if (this.moveNext()) {
			current = this.current();

		} else {
			throw new NoSuchElementException();
		}

		return current;
	}

	/**
	 * @deprecated 使用禁止
	 */
	@Deprecated
	@Override
	public final void remove() {
		throw Errors.invalidOperation();
	}

	// スタティックフィールド
	private static final Enumerator<?> empty = Enumerator.create(null, val -> false, null);

	// スタティックメソッド
	public static <T> Enumerator<T> empty() {
		return (Enumerator<T>) Enumerator.empty;
	}

	public static <T> Enumerator<T> create(Func0<? extends T> first, Predicate<? super T> predicate, Func1<? super T, ? extends T> next) {
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
