package net.kimleo.hjk.internal;

import java.util.function.Function;

public class Trans<T, R> implements Function<T, R> {
    private Function<T, R> trans;

    public Trans(Function<T, R> trans) {
        this.trans = trans;
    }

    @Override
    public R apply(T t) {
        return trans.apply(t);
    }

    public <U> Function<U, R> inject(Function<U, T> fn) {
        return new Trans<>(trans.compose(fn));
    }

}
