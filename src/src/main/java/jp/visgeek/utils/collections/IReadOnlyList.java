package jp.visgeek.utils.collections;

public interface IReadOnlyList<T> extends IReadOnlyCollection<T> {
	T get(int index);
}
