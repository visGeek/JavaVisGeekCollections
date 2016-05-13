package com.github.visgeek.utils.collections.test;

import java.util.Arrays;
import java.util.List;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.EnumerableLinkedList;
import com.github.visgeek.utils.collections.EnumerableLinkedMap;
import com.github.visgeek.utils.collections.EnumerableLinkedSet;
import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.collections.EnumerableSet;
import com.github.visgeek.utils.collections.IDoubleEnumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.IIntegerEnumerable;
import com.github.visgeek.utils.collections.ILongEnumerable;

@SuppressWarnings("unused")
public class ReadMe {
	public static void main(String[] args) {
		// Object
		Cat taro = new Cat();
		Cat jiro = new Cat();
		Cat saburo = new Cat();

		//@formatter:off
// Usage
List<Integer> values =
		Enumerable.of(2, 4, 6, 1, 5, 3)
				.where(val -> val <= 3)
				.orderBy(val -> val)
				.toList();

values.forEach(val -> System.out.print(val)); // 123

// from array
Cat[] catArray = new Cat[] { taro, jiro, saburo };
IEnumerable<Cat> cats1 = Enumerable.of(catArray);

// from variable arguments
IEnumerable<Cat> cats2 = Enumerable.of(taro, jiro, saburo);

// from Iterable<T>
Iterable<Cat> catList = Arrays.asList(catArray);
IEnumerable<Cat> cats3 = Enumerable.of(catList);

// int
IIntegerEnumerable intValues1 = Enumerable.of(new int[] { 1, 2, 3 });         // from array
IIntegerEnumerable intValues2 = Enumerable.of(1, 2, 3);                       // from variable arguments
IIntegerEnumerable intValues3 = Enumerable.ofInteger(Arrays.asList(1, 2, 3)); // from Iterable<T>

// long
ILongEnumerable longValues1 = Enumerable.of(new long[] { 1L, 2L, 3L });
ILongEnumerable longValues2 = Enumerable.of(1L, 2L, 3L);
ILongEnumerable longValues3 = Enumerable.ofLong(Arrays.asList(1L, 2L, 3L));

// double
IDoubleEnumerable doubleValues1 = Enumerable.of(new double[] { 1.0, 2.0, 3.0 });
IDoubleEnumerable doubleValues2 = Enumerable.of(1.0, 2.0, 3.0);
IDoubleEnumerable doublevalues3 = Enumerable.ofDouble(Arrays.asList(1.0, 2.0, 3.0));

// char
IEnumerable<Character> charValues1 = Enumerable.of(new char[] { 'a', 'b', 'c' });
IEnumerable<Character> charValues3 = Enumerable.ofCharacter("abc");

// Collections
EnumerableList<Integer>                   list = new EnumerableList<>();       // extends ArrayList<T>        implements IReadOnlyList<T>
EnumerableLinkedList<Integer>       linkedList = new EnumerableLinkedList<>(); // extends LinkedList<T>       implements IReadOnlyList<T>
EnumerableMap<String, Integer>             map = new EnumerableMap<>();        // extends HashMap<K, V>       implements IReadOnlyMap<T>
EnumerableLinkedMap<String, Integer> linkedMap = new EnumerableLinkedMap<>();  // extends LinkedHashMap<K, V> implements IReadOnlyMap<T>
EnumerableSet<Integer>                     set = new EnumerableSet<>();        // extends HashSet<T>          implements IReadOnlySet<T>
EnumerableLinkedSet<Integer>         linkedSet = new EnumerableLinkedSet<>();  // extends LinkedHashSet<T>    implements IReadOnlySet<T>
		//@formatter:on
	}

	private static class Cat {
	}
}
