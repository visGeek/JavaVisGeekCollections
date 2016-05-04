package com.github.visgeek.utils;

/**
 * 引数が 1 つで戻り値があるメソッドを表します。
 * @param <T>
 * @param <TResult>
 */
@FunctionalInterface
public interface Func1<T, TResult> {
	// メソッド
	TResult func(T arg);

	/**
	 * 引数を指定して引数がないメソッドに変換します。
	 * @param arg
	 * @return
	 */
	default Func0<TResult> toFunc0(T arg) {
		return () -> this.func(arg);
	}

	// スタティックメソッド
	/**
	 * 検査例外のある式をラッピングします。
	 * @param func1WithException
	 * @return
	 */
	public static <T, TResult> Func1<T, TResult> create(Func1WithException<T, TResult> funcWithException) {
		return arg -> {
			try {
				return funcWithException.func(arg);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}

	/**
	 * 複数の条件を合成します。
	 * @param predicates
	 * @return
	 */
	@SafeVarargs
	public static <T> Func1<T, Boolean> mergePredicates(Func1<T, Boolean>... predicates) {
		return arg -> {
			boolean result = true;

			for (Func1<T, Boolean> predicate : predicates) {
				if (!predicate.func(arg)) {
					result = false;
					break;
				}
			}

			return result;
		};
	}

	/**
	 * 複数の条件を合成します。
	 * @param predicates
	 * @return
	 */
	public static <T> Func1<T, Boolean> mergePredicates(Iterable<Func1<T, Boolean>> predicates) {
		return arg -> {
			boolean result = true;

			for (Func1<T, Boolean> predicate : predicates) {
				if (!predicate.func(arg)) {
					result = false;
					break;
				}
			}

			return result;
		};
	}
}
