package net.kimleo.hjk.internal;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Assoc<T, U, R> implements BiFunction<T, U, R> {
    private BiFunction<T, U, R> assoc;

    public Assoc(BiFunction<T, U, R> assoc) {
        this.assoc = assoc;
    }

    public Trans<U, R> bind1st(T t) {
        return new Trans<>(u -> assoc.apply(t, u));
    }

    public Trans<T, R> bind2nd(U u) {
        return new Trans<>(t -> assoc.apply(t, u));
    }

    public <V> Assoc<T, V, R> injectR(Function<V, U> transVU) {
        return new Assoc<>((t, v) -> assoc.apply(t, transVU.apply(v)));
    }

    public <V> Assoc<V, U, R> injectL(Function<V, T> transVT) {
        return new Assoc<>((v, u) -> assoc.apply(transVT.apply(v), u));
    }

    public Assoc<U, T, R> exchange() {
        return new Assoc<>((u, t) -> assoc.apply(t, u));
    }

    @Override
    public R apply(T t, U u) {
        return assoc.apply(t, u);
    }
}
