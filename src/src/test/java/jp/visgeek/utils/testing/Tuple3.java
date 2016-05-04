package jp.visgeek.utils.testing;

public class Tuple3<T1, T2, T3> {
	public Tuple3(T1 item1, T2 item2, T3 item3) {
		this._item1 = item1;
		this._item2 = item2;
		this._item3 = item3;
	}

	private final T1 _item1;

	private final T2 _item2;

	private final T3 _item3;

	public final T1 item1() {
		return this._item1;
	}

	public final T2 item2() {
		return this._item2;
	}

	public final T3 item3() {
		return this._item3;
	}
}
