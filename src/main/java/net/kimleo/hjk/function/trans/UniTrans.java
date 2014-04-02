package net.kimleo.hjk.function.trans;

import java.util.function.Function;

@FunctionalInterface
public interface UniTrans<T> extends Function<T, T> {
}
