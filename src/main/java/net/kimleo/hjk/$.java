package net.kimleo.hjk;

import net.kimleo.hjk.function.TriFunction;
import net.kimleo.hjk.function.op.BinOp;
import net.kimleo.hjk.function.op.TriOp;
import net.kimleo.hjk.function.op.UnaOp;
import net.kimleo.hjk.function.pred.BinPred;
import net.kimleo.hjk.function.pred.TriPred;
import net.kimleo.hjk.internal.Assoc;
import net.kimleo.hjk.internal.Trans;
import net.kimleo.hjk.internal.TriFn;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Kim Leo on 14-4-1.
 */
public class $ {
    public static <T, R> Trans<T, R> on(Function<T, R> trans) {
        return new Trans<>(trans);
    }

    public static <T, U, R> Assoc<T, U, R> on(BiFunction<T, U, R> assoc) {
        return new Assoc<>(assoc);
    }

    public static <T, U, V, R> TriFn<T, U, V, R> on(TriFunction<T, U, V, R> triFn) {
        return new TriFn<>(triFn);
    }

    public static <T> Trans<T, T> op(UnaOp<T> trans) {
        return on(trans);
    }

    public static <T> Assoc<T, T, T> op(BinOp<T> assoc) {
        return on(assoc);
    }

    public static <T> TriFn<T, T, T, T> op(TriOp<T> triOp) {
        return on(triOp);
    }

    public static <T> Trans<T, Boolean> pred(Predicate<T> trans) {
        return new Trans<>(trans::test);
    }

    public static <T, U> Assoc<T, U, Boolean> pred(BinPred<T, U> assoc) {
        return on(assoc);
    }

    public static <T, U, V> TriFn<T, U, V, Boolean> pred(TriPred<T, U, V> triPred) {
        return on(triPred);
    }
}
