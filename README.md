# visGeekCollections
Java で LINQ を実現します。

## Usage

```Java
// Usage
List<Integer> values =
		Enumerable.of(2, 4, 6, 1, 5, 3)
				.where(val -> val <= 3)
				.orderBy(val -> val)
				.toList();

values.forEach(val -> System.out.print(val)); // 123

// from array
Cat[] catArray = new Cat[] { taro, jiro, sabro };
IEnumerable<Cat> cats1 = Enumerable.of(catArray);

// from variable arguments
IEnumerable<Cat> cats2 = Enumerable.of(taro, jiro, sabro);

// from Iterable<T>
Iterable<Cat> catList = Arrays.asList(catArray);
IEnumerable<Cat> cats3 = Enumerable.of(catList);

// int
IIntegerEnumerable intValues1 = Enumerable.ofInteger(new int[] { 1, 2, 3 });  // from array
IIntegerEnumerable intValues2 = Enumerable.ofInteger(1, 2, 3);                // from variable arguments
IIntegerEnumerable intValues3 = Enumerable.ofInteger(Arrays.asList(1, 2, 3)); // from Iterable<T>

// long
ILongEnumerable longValues1 = Enumerable.ofLong(new long[] { 1L, 2L, 3L });
ILongEnumerable longValues2 = Enumerable.ofLong(1L, 2L, 3L);
ILongEnumerable longValues3 = Enumerable.ofLong(Arrays.asList(1L, 2L, 3L));

// double
IDoubleEnumerable doubleValues1 = Enumerable.ofDouble(new double[] { 1.0, 2.0, 3.0 });
IDoubleEnumerable doubleValues2 = Enumerable.ofDouble(1.0, 2.0, 3.0);
IDoubleEnumerable doublevalues3 = Enumerable.ofDouble(Arrays.asList(1.0, 2.0, 3.0));

// char
IEnumerable<Character> charValues1 = Enumerable.ofCharacter(new char[] { 'a', 'b', 'c' });
IEnumerable<Character> charValues2 = Enumerable.ofCharacter('a', 'b', 'c');
IEnumerable<Character> charValues3 = Enumerable.ofCharacter("abc");
IEnumerable<Character> charValues4 = Enumerable.ofCharacter(123); // object.toString()

// Collections
EnumerableList<Integer>                   list = new EnumerableList<>();       // extends ArrayList<T>        implements IReadOnlyList<T>
EnumerableLinkedList<Integer>       linkedList = new EnumerableLinkedList<>(); // extends LinkedList<T>       implements IReadOnlyList<T>
EnumerableMap<String, Integer>             map = new EnumerableMap<>();        // extends HashMap<K, V>       implements IReadOnlyMap<T>
EnumerableLinkedMap<String, Integer> linkedMap = new EnumerableLinkedMap<>();  // extends LinkedHashMap<K, V> implements IReadOnlyMap<T>
EnumerableSet<Integer>                     set = new EnumerableSet<>();        // extends HashSet<T>          implements IReadOnlySet<T>
EnumerableLinkedSet<Integer>         linkedSet = new EnumerableLinkedSet<>();  // extends LinkedHashSet<T>    implements IReadOnlySet<T>
```
