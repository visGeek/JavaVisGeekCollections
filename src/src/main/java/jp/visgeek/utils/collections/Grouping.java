package jp.visgeek.utils.collections;

import java.util.Iterator;

class Grouping<TKey, TElement> implements IGrouping<TKey, TElement> {
	// コンストラクター
	public Grouping(TKey key) {
		this.key = key;
	}

	// フィールド
	private final TKey key;

	private final EnumerableList<TElement> list = new EnumerableList<TElement>();

	// メソッド
	final void add(TElement element) {
		this.list.add(element);
	}

	@Override
	public final TKey key() {
		return this.key;
	}

	@Override
	public final Iterator<TElement> iterator() {
		return this.list.iterator();
	}
}
