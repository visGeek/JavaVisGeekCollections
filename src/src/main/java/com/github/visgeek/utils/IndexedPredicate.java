package com.github.visgeek.utils;

@FunctionalInterface
public interface IndexedPredicate<T> {
	boolean test(T t, int index);

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
}
