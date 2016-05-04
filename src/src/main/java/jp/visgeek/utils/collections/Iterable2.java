package jp.visgeek.utils.collections;

import java.util.Iterator;

public interface Iterable2<T> extends Iterable<T> {
	default IEnumerable<T> asEnumerable() {
		return new IEnumerable<T>() {
			@Override
			public Iterator<T> iterator() {
				return Iterable2.this.iterator();
			}
		};
	}
}
