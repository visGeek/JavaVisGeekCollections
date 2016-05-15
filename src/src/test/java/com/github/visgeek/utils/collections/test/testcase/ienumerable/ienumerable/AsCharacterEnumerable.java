package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.ICharacterEnumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.testing.Assert2;

public class AsCharacterEnumerable {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void isICharacterEnumerable() {
		IEnumerable<Character> source = Enumerable.of('a', 'b', 'c');
		ICharacterEnumerable source2 = source.asCharacterEnumerable();
		source2.max();
	}

	@Test
	public void isCharacterEnumerable() {
		IEnumerable<Character> source = () -> Enumerable.of('a', 'b', 'c').iterator();
		ICharacterEnumerable source2 = source.asCharacterEnumerable();
		source2.max();
	}

	@Test
	public void noException() {
		IEnumerable<String> source = Enumerable.of("a", "b", "c");
		Action0 action = () -> source.asCharacterEnumerable();
		Assert2.assertExceptionNotThrown(action);
	}
}
