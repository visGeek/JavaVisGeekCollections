package com.github.visgeek.utils.functions;

@FunctionalInterface
public interface Predicate<T> extends java.util.function.Predicate<T> {
	// スタティックメソッド
	/**
	 * 検査例外のある式をラッピングします。
	 * @param func1WithException
	 * @return
	 */
	public static <T> Predicate<T> create(PredicateWithException<T> indexedPredicateWithException) {
		return (arg) -> {
			try {
				return indexedPredicateWithException.test(arg);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
