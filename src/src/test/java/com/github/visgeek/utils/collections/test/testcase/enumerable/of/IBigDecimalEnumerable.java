package com.github.visgeek.utils.collections.test.testcase.enumerable.of;

import java.math.BigDecimal;

import com.github.visgeek.utils.collections.IEnumerable;

public interface IBigDecimalEnumerable extends IEnumerable<BigDecimal> {
	/**
	 * null 以外の値の平均値を取得します。
	 * @return null 以外の値の平均値。シーケンスが空、または null のみの場合は null。
	 */
	default BigDecimal average() {
		BigDecimal sum = BigDecimal.ZERO;
		long cnt = 0;

		for (BigDecimal value : this) {
			if (value != null) {
				sum = sum.add(value);
				cnt++;
			}
		}

		if (cnt == 0) {
			return null;
		} else {
			return sum.divide(BigDecimal.valueOf(cnt));
		}
	}

	/**
	 * null 以外の値の合計値を取得します。
	 * @return
	 */
	default BigDecimal sum() {
		BigDecimal sum = BigDecimal.ZERO;

		for (BigDecimal value : this) {
			if (value != null) {
				sum = sum.add(value);
			}
		}

		return sum;
	}
}
