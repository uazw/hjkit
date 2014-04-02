package net.kimleo.hjk.function.trans;

import net.kimleo.hjk.function.TriFunction;

@FunctionalInterface
public interface TriTrans<T, R> extends TriFunction<T, T, T, R> {
}
