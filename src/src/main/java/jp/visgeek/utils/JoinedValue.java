package jp.visgeek.utils;

import java.util.Objects;

public class JoinedValue<TOuter, TInner> {
	// コンストラクター
	public JoinedValue(TOuter outer, TInner inner) {
		this.outer = outer;
		this.inner = inner;
	}

	// フィールド
	private final TOuter outer;

	private final TInner inner;

	// プロパティ
	public final TOuter outer() {
		return this.outer;
	}

	public final TInner inner() {
		return this.inner;
	}

	// メソッド
	@Override
	@Deprecated
	public final boolean equals(Object obj) {
		boolean result = false;

		if (obj instanceof JoinedValue<?, ?>) {
			JoinedValue<?, ?> cast = (JoinedValue<?, ?>) obj;

			if (Objects.equals(this.outer, cast.outer)) {
				if (Objects.equals(this.inner, cast.inner)) {
					result = true;
				}
			}
		}

		return result;
	}

	public final boolean equals(JoinedValue<TOuter, TInner> obj) {
		return this.equals(obj.outer, obj.inner);
	}

	public final boolean equals(TOuter outer, TInner inner) {
		boolean result = false;

		if (Objects.equals(this.outer, outer)) {
			if (Objects.equals(this.inner, inner)) {
				result = true;
			}
		}

		return result;
	}

	@Override
	public final int hashCode() {
		int outerHash = this.outer == null ? 0 : this.outer.hashCode();
		int innerHash = this.inner == null ? 0 : this.inner.hashCode();
		return outerHash * 31 + innerHash * 37;
	}

	@Override
	public String toString() {
		return String.format("outer:%s, inner:%s", this.outer, this.inner);
	}

	// スタティックフィールド

	// スタティックイニシャライザー

	// スタティックメソッド
	public static <TOuter, TInner> JoinedValue<TOuter, TInner> create(TOuter outer, TInner inner) {
		return new JoinedValue<>(outer, inner);
	}
}
