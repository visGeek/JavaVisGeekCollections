package com.github.visgeek.utils;

import java.util.Objects;

/**
 * 等価比較のためのメソッドを実装します。
 *
 *
 * @param <T>
 */
public interface IEqualityComparator<T> {
	// メソッド
	boolean equals(T a, T b);

	int hashCode(T a);

	// スタティックフィールド
	/**
	 * デフォルトのインスタンス
	 */
	static final IEqualityComparator<?> DEFAULT_COMPARATOR =
			new IEqualityComparator<Object>() {
				@Override
				public boolean equals(Object a, Object b) {
					return Objects.equals(a, b);
				}

				@Override
				public int hashCode(Object obj) {
					return obj == null ? 0 : obj.hashCode();
				}
			};

	// スタティックメソッド
	/**
	 * インスタンスを作成します。
	 * @param hashCode
	 * @param equals
	 * @return
	 */
	public static <T> IEqualityComparator<T> create(Func1<T, Integer> hashCode, Func2<T, T, Boolean> equals) {
		return new IEqualityComparator<T>() {
			@Override
			public boolean equals(T a, T b) {
				return equals.func(a, b);
			}

			@Override
			public int hashCode(T obj) {
				return hashCode.func(obj);
			}
		};
	}

	/**
	 * 指定したセレクター関数で取得される要素を使って等価比較する比較子を作成します。
	 * @param selector
	 * @return
	 */
	public static <T, TResult> IEqualityComparator<T> create(Func1<T, TResult> selector) {
		return new IEqualityComparator<T>() {
			@Override
			public boolean equals(T a, T b) {
				TResult a2 = selector.func(a);
				TResult b2 = selector.func(b);
				return Objects.equals(a2, b2);
			}

			@Override
			public int hashCode(T a) {
				TResult a2 = selector.func(a);
				return Objects.hashCode(a2);
			}
		};
	}

	/**
	 * インスタンスを作成します。
	 * @param hashCode
	 * @param equals
	 * @return
	 */
	public static <T> IEqualityComparator<T> getDefault() {
		@SuppressWarnings("unchecked")
		IEqualityComparator<T> result = (IEqualityComparator<T>) IEqualityComparator.DEFAULT_COMPARATOR;
		return result;
	}
}
