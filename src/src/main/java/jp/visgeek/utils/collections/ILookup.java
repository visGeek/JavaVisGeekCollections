package jp.visgeek.utils.collections;

public interface ILookup<TKey, TElement> extends IEnumerable<IGrouping<TKey, TElement>> {
	@Override
	default int count() {
		return IEnumerable.super.count();
	}

	IEnumerable<TElement> get(TKey key);
}
