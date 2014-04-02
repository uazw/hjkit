package net.kimleo.hjk.collect;

import net.kimleo.hjk.function.BinFunction;
import net.kimleo.hjk.internal.Iter;
import net.kimleo.hjk.internal.Mapp;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class IterKit {
    public static <T, V> Iter<T> map(Function<V, T> fun, Iterable<V> iter) {
        LinkedList<T> ts = new LinkedList<T>();
        for (V v : iter)
            ts.add(fun.apply(v));
        return new Iter<>(ts);
    }

    public static <T> Iter<T> filter(Predicate<T> pred, Iterable<T> iter) {
        LinkedList<T> ts = new LinkedList<>();
        for (T t : iter) {
            if (pred.test(t))
                ts.add(t);
        }
        return new Iter<>(ts);
    }

    public static <V, T> V reduce(Iterable<T> ts, V init, BinFunction<T, V, V> reducer) {
        V value = init;
        for (T i : ts) {
            value = reducer.apply(i, value);
        }
        return value;
    }

    public static <T, V> Mapp<T, V> zip(List<T> list, List<V> list1) {
        return MapKit.from(list, list1);
    }
}
