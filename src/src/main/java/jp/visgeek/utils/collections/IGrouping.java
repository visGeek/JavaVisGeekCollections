package jp.visgeek.utils.collections;

public interface IGrouping<TKey, TElement> extends IEnumerable<TElement> {
	TKey key();
}
