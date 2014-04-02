package net.kimleo.hjk;

import net.kimleo.hjk.collect.MapKit;
import net.kimleo.hjk.internal.Iter;
import net.kimleo.hjk.internal.Mapp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class _ {
    public static <T> Iter<T> on(Iterable<T> list) {
        return new Iter<>(list);
    }

    public static <K, V> Mapp<K, V> on(Map<K, V> map) {
        return new Mapp<>(map);
    }

    public static <K, V> Mapp<K, V> map(List<K> keys, List<V> values) {
        return MapKit.from(keys, values);
    }

    public static <K, V> Mapp<K, V> map(K[] keys, V[] values) {
        return map(Arrays.asList(keys), Arrays.asList(values));
    }

}
