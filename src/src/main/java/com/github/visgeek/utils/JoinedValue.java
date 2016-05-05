package com.github.visgeek.utils;

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
	@Deprecated
	@Override
	@SuppressWarnings("unchecked")
	public final boolean equals(Object obj) {
		boolean result = false;

		if (obj instanceof JoinedValue<?, ?>) {
			if (this.equals((JoinedValue<TOuter, TInner>) obj)) {
				result = true;
			}
		}

		return result;
	}

	public final boolean equals(JoinedValue<TOuter, TInner> obj) {
		boolean result = false;

		if (obj != null) {
			if (this.equals(obj.outer(), obj.inner())) {
				result = true;
			}
		}

		return result;
	}

	public final boolean equals(TOuter outer, TInner inner) {
		boolean result = false;

		if (Objects.equals(this.outer(), outer)) {
			if (Objects.equals(this.inner(), inner)) {
				result = true;
			}
		}

		return result;
	}

	@Override
	public final int hashCode() {
		return Objects.hash(this.outer(), this.inner());
	}

	@Override
	public String toString() {
		return String.format("outer:%s, inner:%s", this.outer(), this.inner());
	}

	// スタティックフィールド

	// スタティックイニシャライザー

	// スタティックメソッド
	public static <TOuter, TInner> JoinedValue<TOuter, TInner> create(TOuter outer, TInner inner) {
		return new JoinedValue<>(outer, inner);
	}
}
