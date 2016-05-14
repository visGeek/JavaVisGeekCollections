package com.github.visgeek.utils.collections.test.testcase.ireadonlycollection;

import java.util.Collection;
import java.util.Iterator;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.EnumerableList;

@SuppressWarnings("deprecation")
class ItemCollection implements Collection<Item> {
	ItemCollection(int... values) {
		this.items = Enumerable.of(values).select(value -> new Item(value)).toList();
	}

	private final EnumerableList<Item> items;

	@Override
	public int size() {
		return this.items.size();
	}

	@Override
	public boolean isEmpty() {
		return this.items.isEmpty();
	}

	@Override
	public boolean contains(Object paramObject) {
		return this.items.contains(paramObject);
	}

	@Override
	public Iterator<Item> iterator() {
		return this.items.iterator();
	}

	@Override
	public Object[] toArray() {
		return this.items.toArray();
	}

	@Override
	public <T> T[] toArray(T[] paramArrayOfT) {
		return this.items.toArray(paramArrayOfT);
	}

	@Override
	public boolean add(Item paramE) {
		return this.items.add(paramE);
	}

	@Override
	public boolean remove(Object paramObject) {
		return this.items.remove(paramObject);
	}

	@Override
	public boolean containsAll(Collection<?> paramCollection) {
		return this.items.containsAll(paramCollection);
	}

	@Override
	public boolean addAll(Collection<? extends Item> paramCollection) {
		return this.items.addAll(paramCollection);
	}

	@Override
	public boolean removeAll(Collection<?> paramCollection) {
		return this.items.removeAll(paramCollection);
	}

	@Override
	public boolean retainAll(Collection<?> paramCollection) {
		return this.items.retainAll(paramCollection);
	}

	@Override
	public void clear() {
		this.items.clear();
	}
}
