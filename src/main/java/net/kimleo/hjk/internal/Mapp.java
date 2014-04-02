package net.kimleo.hjk.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("NullableProblems")
public class Mapp<K, V> implements Iterable<Map.Entry<K, V>>, Map<K, V> {
    private Map<K, V> innerMap;

    public Mapp(Map<K, V> map) {
        innerMap = map;
    }

    public Map<K, V> asMap() {
        return innerMap;
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return innerMap.entrySet().iterator();
    }

    public Iter<Entry<K, V>> iter() {
        return new Iter<>(this);
    }

    @Override
    public int size() {
        return innerMap.size();
    }

    @Override
    public boolean isEmpty() {
        return innerMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return innerMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return innerMap.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return innerMap.get(key);
    }

    @Override
    public V put(K key, V value) {
        return innerMap.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return innerMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        innerMap.putAll(m);
    }

    @Override
    public void clear() {
        innerMap.clear();
    }

    @Override
    public Set<K> keySet() {
        return innerMap.keySet();
    }

    @Override
    public Collection<V> values() {
        return innerMap.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return innerMap.entrySet();
    }
}
