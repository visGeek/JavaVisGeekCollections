package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ForEach {
	@Test
	public void test() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();

		List<String> list = new ArrayList<>();
		source.forEach((n, idx) -> list.add(String.format("%d:%s", idx, n)));

		Assert2.assertSequanceEquals(list, "0:1", "1:2", "2:3");
	}
}
