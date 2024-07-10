package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        SoftReference<V> reference = new SoftReference<>(value);
        cache.put(key, reference);
    }

    public final V get(K key) {
        V value;
        SoftReference<V> reference = cache.get(key);
        if (reference == null) {
            value = load(key);
        } else {
            value = reference.get();
        }
        return value;
    }

    protected abstract V load(K key);
}
