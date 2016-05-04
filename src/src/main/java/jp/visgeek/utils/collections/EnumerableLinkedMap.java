package jp.visgeek.utils.collections;

import java.util.Iterator;
import java.util.Map.Entry;

import jp.visgeek.utils.Func0;
import jp.visgeek.utils.Func1;
import jp.visgeek.utils.Func2;

/**
 * java.util.LinkedHashMap&lt;K, V&gt; の機能と IEnumerable&lt;T&gt; の機能を提供します。
 * @param <K>
 * @param <V>
 */
public class EnumerableLinkedMap<K, V> extends java.util.LinkedHashMap<K, V> implements IReadOnlyMap<K, V> {
	// コンストラクター
	public EnumerableLinkedMap() {
		super();
	}

	public EnumerableLinkedMap(java.util.Map<? extends K, ? extends V> m) {
		super(m);
	}

	public EnumerableLinkedMap(int initialCapacity) {
		super(initialCapacity);
	}

	public EnumerableLinkedMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	public EnumerableLinkedMap(int initialCapacity, float loadFactor, boolean accessOrder) {
		super(initialCapacity, loadFactor, accessOrder);
	}

	public EnumerableLinkedMap(IReadOnlyMap<? extends K, ? extends V> m) {
		this();
		for (Entry<? extends K, ? extends V> kv : m) {
			this.put(kv.getKey(), kv.getValue());
		}
	}

	// フィールド

	// メソッド
	@Override
	public Object clone() {
		return new EnumerableLinkedMap<>((java.util.Map<? extends K, ? extends V>) this);
	}

	@Override
	@Deprecated
	public boolean containsKey(Object key) {
		return super.containsKey(key);
	}

	public boolean containsKey2(K key) {
		return super.containsKey(key);
	}

	@Override
	@Deprecated
	public boolean containsValue(Object value) {
		return super.containsValue(value);
	}

	public boolean containsValue2(V value) {
		return super.containsValue(value);
	}

	@Override
	@Deprecated
	public V get(Object key) {
		return super.get(key);
	}

	/**
	 * get(Object key) と同じ動作です。
	 * @param key
	 * @return
	 */
	public V getValue(K key) {
		return super.get(key);
	}

	/**
	 * キーに関連する値を取得します。登録されていない場合は規定値を登録します。
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public V getValueOrPut(K key, Func1<K, ? extends V> defaultValue) {
		return this.getValueOrPut(key, defaultValue, null);
	}

	/**
	 * キーに関連する値を取得します。登録されていない場合は規定値を登録します。ロック用オブジェクトを指定すると同期的登録処理となります。
	 * @param key
	 * @param defaultValue
	 * @param lockObject 同期処理のためのロック用オブジェクト。または null。
	 * @return
	 */
	public V getValueOrPut(K key, Func1<K, ? extends V> defaultValue, Object lockObject) {
		return this.getValueOrPut(key, () -> defaultValue.func(key), lockObject);
	}

	/**
	 * キーに関連する値を取得します。登録されていない場合は規定値を登録します。
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public V getValueOrPut(K key, Func0<? extends V> defaultValue) {
		return this.getValueOrPut(key, defaultValue, null);
	}

	/**
	 * キーに関連する値を取得します。登録されていない場合は規定値を登録します。ロック用オブジェクトを指定すると同期的登録処理となります。
	 * @param key
	 * @param defaultValue
	 * @param lockObject 同期処理のためのロック用オブジェクト。または null。
	 * @return
	 */
	public V getValueOrPut(K key, Func0<? extends V> defaultValue, Object lockObject) {
		V result;

		result = this.getValue(key);
		if (result == null) {
			if (lockObject == null) {
				result = defaultValue.func();
				this.put(key, result);
			} else {
				synchronized (lockObject) {
					result = this.getValue(key);
					if (result == null) {
						result = defaultValue.func();
						this.put(key, result);
					}
				}
			}
		}

		return result;
	}

	@Override
	public IEnumerable<K> enumerateKeys() {
		return Enumerable.of(this.keySet());
	}

	@Override
	public IEnumerable<V> enumerateValues() {
		return Enumerable.of(this.values());
	}

	public V putOrThrow(K key, V value) {
		return this.putOrThrow(key, value, (k, v) -> String.format("key %s is already contained.", key));
	}

	public V putOrThrow(K key, V value, String errorMessage) {
		return this.putOrThrow(key, value, (k, v) -> errorMessage);
	}

	public V putOrThrow(K key, V value, Func2<K, V, String> errorMessage) {
		if (this.containsKey2(key)) {
			throw new IllegalArgumentException(errorMessage.func(key, value));
		} else {
			return this.put(key, value);
		}
	}

	/**
	 * キーに関連する値が登録されていない場合に値を登録します。
	 * @param key
	 * @param value
	 * @return
	 */
	public V putIfAbsent(K key, Func0<? extends V> value) {
		V result = null;

		if (!this.containsKey2(key)) {
			result = this.putIfAbsent(key, value.func());
		}

		return result;
	}

	public void putAll(IEnumerable<? extends V> values, Func1<? super V, ? extends K> keySelector) {
		for (V value : values) {
			K key = keySelector.func(value);
			this.put(key, value);
		}
	}

	@Override
	@Deprecated
	public V remove(Object key) {
		return super.remove(key);
	}

	/**
	 * remove(Object key) と同じ動作です。
	 * @param key
	 * @return
	 */
	public V removeValue(K key) {
		return super.remove(key);
	}

	public V removeValueOrThrow(K key) {
		if (this.containsKey2(key)) {
			return this.removeValue(key);
		} else {
			throw new IllegalArgumentException(String.format("key '%s' is not found.", key));
		}
	}

	public V removeValueOrDefault(K key, V defaultValue) {
		return this.removeValueOrDefault(key, () -> defaultValue);
	}

	public V removeValueOrDefault(K key, Func0<? extends V> defaultValue) {
		if (this.containsKey2(key)) {
			return this.removeValue(key);
		} else {
			return defaultValue.func();
		}
	}

	@Override
	public Iterator<Entry<K, V>> iterator() {
		return this.entrySet().iterator();
	}

	@Override
	public IKeyValueCollection<K, V> toKeyValueCollection() {
		return new KeyValueCollection<>(this);
	}

	@Override
	public String toString() {
		return String.format("size:%d", this.size());
	}

	// スタティッククラス

	// スタティックフィールド
	private static final long serialVersionUID = -7179232799171941533L;

	// スタティックメソッド
}
