package com.github.visgeek.utils.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class LinqShuffleIterator<T> extends AbstractSimpleIterator<T, T> {
	public LinqShuffleIterator(Iterable<T> source, Random rnd) {
		super(source);
		this.rnd = rnd;
	}

	private final Random rnd;

	private Iterator<T> itr;

	@Override
	public boolean hasNext() {
		if (this.itr == null) {
			List<T> list = new ArrayList<T>();
			while (this.iterator.hasNext()) {
				list.add(this.iterator.next());
			}

			if (rnd == null) {
				Collections.shuffle(list);
			} else {
				Collections.shuffle(list, rnd);
			}

			this.itr = list.iterator();
		}

		return this.itr.hasNext();
	}

	@Override
	public T next() {
		return this.itr.next();
	}
}
