package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IGrouping;
import com.github.visgeek.utils.testing.Assert2;

public class GroupBy {
	@Test
	public void test_groupBy01() {
		List<IGrouping<Integer, Integer>> actual =
				Enumerable
						.of(2, 1, 3, 1)
						.groupBy(n -> n)
						.toList();

		Assert.assertEquals(3, actual.size());

		Assert.assertEquals(2, (int) actual.get(0).key());
		Assert2.assertSequanceEquals(actual.get(0), 2);

		Assert.assertEquals(1, (int) actual.get(1).key());
		Assert2.assertSequanceEquals(actual.get(1), 1, 1);

		Assert.assertEquals(3, (int) actual.get(2).key());
		Assert2.assertSequanceEquals(actual.get(2), 3);
	}
}
