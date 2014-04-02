package net.kimleo.hjk.internal;

import net.kimleo.hjk.function.TriFunction;

public class TriFn<T, U, V, R> implements TriFunction<T, U, V, R> {
    private TriFunction<T, U, V, R> triFn;

    public TriFn(TriFunction<T, U, V, R> triFn) {
        this.triFn = triFn;
    }

    @Override
    public R apply(T t, U u, V v) {
        return triFn.apply(t, u, v);
    }

    public Assoc<U, V, R> bind1st(T t) {
        return new Assoc<>((u, v) -> triFn.apply(t, u, v));
    }

    public Assoc<T, V, R> bind2nd(U u) {
        return new Assoc<>((t, v) -> triFn.apply(t, u, v));
    }

    public Assoc<T, U, R> bind3rd(V v) {
        return new Assoc<>((t, u) -> triFn.apply(t, u, v));
    }
}
