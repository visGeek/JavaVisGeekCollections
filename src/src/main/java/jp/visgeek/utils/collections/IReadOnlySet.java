package jp.visgeek.utils.collections;

public interface IReadOnlySet<T> extends IReadOnlyCollection<T> {
	@Override
	int size();
}
