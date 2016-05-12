package com.github.visgeek.utils.collections;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

import com.github.visgeek.utils.Func0;
import com.github.visgeek.utils.Func1;

public interface IReadOnlyMap<K, V> extends IReadOnlyCollection<Entry<K, V>> {
	boolean containsKey(K key);

	boolean containsValue(V value);

	@Override
	default int count() {
		return this.size();
	}

	V get(K key);

	/**
	 * 指定したキーに関連付けられた値を取得します。キーが登録されていない場合は例外が発生します。
	 * @param key
	 * @return
	 */
	default V getValueOrThrow(K key) {
		if (this.containsKey(key)) {
			return this.get(key);
		} else {
			throw new IllegalArgumentException(String.format("key '%s' is not found.", key));
		}
	}

	/**
	 * getOrDefault(Object Key, V defaultValue) と同じ動作です。
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	V getValueOrDefault(K key, V defaultValue);

	/**
	 * 指定したキーに関連付けられた値を取得します。キーが登録されていない場合は指定した関数の結果を取得しますがこの値は登録されません。
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	default V getValueOrDefault(K key, Func0<? extends V> defaultValue) {
		Errors.throwIfNull(defaultValue, "defaultValue");

		if (this.containsKey(key)) {
			return this.get(key);
		} else {
			return defaultValue.func();
		}
	}

	/**
	 * 指定したキーに関連付けられた値を取得します。キーが登録されていない場合は指定した関数の結果を取得しますがこの値は登録されません。
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	default V getValueOrDefault(K key, Func1<? super K, ? extends V> defaultValue) {
		Errors.throwIfNull(defaultValue, "defaultValue");

		if (this.containsKey(key)) {
			return this.get(key);
		} else {
			return defaultValue.func(key);
		}
	}

	/**
	 * 登録されているキーを列挙します。
	 * @return
	 */
	default IEnumerable<K> enumerateKeys() {
		return Enumerable.of(this.keySet());
	}

	/**
	 * 登録されているキーを列挙します。
	 * @return
	 */
	default IEnumerable<V> enumerateValues() {
		return Enumerable.of(this.values());
	}

	Set<K> keySet();

	@Override
	int size();

	Collection<V> values();

	public static <K, V extends V2, V2> IReadOnlyMap<K, V2> cast(IReadOnlyMap<K, V> map) {
		@SuppressWarnings("unchecked")
		IReadOnlyMap<K, V2> result = (IReadOnlyMap<K, V2>) map;
		return result;
	}
}
