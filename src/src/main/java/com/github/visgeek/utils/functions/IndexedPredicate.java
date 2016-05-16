package com.github.visgeek.utils.functions;

@FunctionalInterface
public interface IndexedPredicate<T> {
	boolean test(T arg, int index);

	// default IndexedPredicate<T> and(IndexedPredicate<? super T> other) {
	// Objects.requireNonNull(other);
	// return (t, index) -> test(t, index) && other.test(t, index);
	// }
	//
	// default IndexedPredicate<T> negate() {
	// return (t, index) -> !test(t, index);
	// }
	//
	// default IndexedPredicate<T> or(IndexedPredicate<? super T> other) {
	// Objects.requireNonNull(other);
	// return (t, index) -> test(t, index) || other.test(t, index);
	// }
	//
	// static <T> IndexedPredicate<T> isEqual(Object targetRef) {
	// return (null == targetRef)
	// ? (t, index) -> Objects.isNull(t)
	// : (object, index) -> targetRef.equals(object);
	// }

	// スタティックメソッド
	/**
	 * 検査例外のある式をラッピングします。
	 * @param func1WithException
	 * @return
	 */
	public static <T> IndexedPredicate<T> create(WithException<T> indexedPredicateWithException) {
		return (arg, index) -> {
			try {
				return indexedPredicateWithException.test(arg, index);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}

	@FunctionalInterface
	public static interface WithException<T> {
		boolean test(T t, int index) throws Exception;
	}
}
