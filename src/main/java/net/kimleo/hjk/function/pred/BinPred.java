package net.kimleo.hjk.function.pred;

import net.kimleo.hjk.function.BinFunction;

import java.util.function.BiPredicate;

/**
 * @author Kim Leo
 */

@FunctionalInterface
public interface BinPred<T, U> extends BinFunction<T, U, Boolean>, BiPredicate<T, U> {
    default boolean test(T t, U u) {
        return apply(t, u);
    }
}
