package jp.visgeek.utils.collections;

import java.util.NoSuchElementException;

public abstract class AbstractEnumerator<T> implements IEnumerator<T> {
	// コンストラクター
	public AbstractEnumerator() {
	}

	// フィールド
	private boolean isMoved = false;

	private boolean hasNext;

	// メソッド
	@Override
	public abstract T current();

	@Override
	public abstract boolean moveNext();

	/**
	 * @deprecated 使用禁止
	 * @return
	 */
	@Deprecated
	@Override
	public final boolean hasNext() {
		if (!this.isMoved) {
			this.hasNext = this.moveNext();
			this.isMoved = true;
		}

		return this.hasNext;
	}

	/**
	 * @deprecated 使用禁止
	 * @return
	 */
	@Deprecated
	@Override
	public final T next() {
		T current;

		if (this.isMoved) {
			current = this.current();
			this.isMoved = false;

		} else if (this.moveNext()) {
			current = this.current();

		} else {
			throw new NoSuchElementException();
		}

		return current;
	}

	/**
	 * @deprecated 使用禁止
	 */
	@Deprecated
	@Override
	public final void remove() {
		throw Errors.invalidOperation();
	}
}
