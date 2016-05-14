package com.github.visgeek.utils.collections;

/**
 * Iterable&lt;T&gt; の機能と IEnumerable&lt;T&gt; に変換する機能を提供します。
 *
 * @param <T>
 */
public interface Iterable2<T> extends Iterable<T> {
	/**
	 * IEnumerable&lt;T&gt; に変換します。
	 * @return
	 */
	default IEnumerable<T> asEnumerable() {
		return () -> Iterable2.this.iterator();
	}
}
