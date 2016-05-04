package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import jp.visgeek.utils.JoinedValue;
import jp.visgeek.utils.collections.Enumerable;
import jp.visgeek.utils.collections.IEnumerable;
import jp.visgeek.utils.collections.IReadOnlyList;
import jp.visgeek.utils.testing.Assert2;

public class GroupJoin {
	@Test
	public void test_groupJoin01_01() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3);
		IEnumerable<Integer> values2 = Enumerable.of(2, 3);

		IReadOnlyList<JoinedValue<Integer, IReadOnlyList<Integer>>> actual =
				values1
						.groupJoin(values2, arg -> arg, arg -> arg)
						.toList();

		Assert.assertEquals(3, actual.size());

		Assert.assertEquals(1, (int) actual.get(0).outer());
		Assert2.assertSequanceEquals(actual.get(0).inner());

		Assert.assertEquals(2, (int) actual.get(1).outer());
		Assert2.assertSequanceEquals(actual.get(1).inner(), 2);

		Assert.assertEquals(3, (int) actual.get(2).outer());
		Assert2.assertSequanceEquals(actual.get(2).inner(), 3);
	}
}
