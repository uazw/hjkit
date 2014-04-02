package net.kimleo.hjk.internal;

import net.kimleo.hjk.collect.IterKit;
import net.kimleo.hjk.function.BinFunction;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Iter<T> implements Iterable<T> {
    private Iterable<T> innerList;

    public Iter(Iterable<T> list) {
        this.innerList = list;
    }

    public <V> Iter<V> map(Function<T, V> fun) {
        return IterKit.map(fun, this.innerList);
    }

    public Iter<T> select(Predicate<T> pred) {
        return this.filter(pred);
    }

    public Iter<T> filter(Predicate<T> pred) {
        return IterKit.filter(pred, this.innerList);
    }

    public <V> V reduce(V init, BinFunction<T, V, V> fun) {
        return IterKit.reduce(this.innerList, init, fun);
    }

    public <V> Mapp<T, V> zip(Iterable<V> iter) {
        return IterKit.zip(this.asList(), new Iter<>(iter).asList());
    }

    public List<T> asList() {
        List<T> ts = new LinkedList<>();
        for (T t : innerList)
            ts.add(t);
        return ts;
    }

    @Override
    public Iterator<T> iterator() {
        return innerList.iterator();
    }
}
