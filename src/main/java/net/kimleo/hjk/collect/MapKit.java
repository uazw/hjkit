package net.kimleo.hjk.collect;

import net.kimleo.hjk.internal.Mapp;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapKit {
    public static <K, V> Mapp<K, V> from(List<K> keys, List<V> values) {
        Map<K, V> kvMap = new LinkedHashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            if (i < values.size())
                kvMap.put(keys.get(i), values.get(i));
            else
                kvMap.put(keys.get(i), null);
        }
        return new Mapp<>(kvMap);
    }

    public static <K, V> Mapp<K, V> from(K[] keys, V[] values) {
        return from(Arrays.asList(keys), Arrays.asList(values));
    }
}