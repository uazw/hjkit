package net.kimleo.hjk.function.op;

import net.kimleo.hjk.function.BinFunction;

import java.util.function.BinaryOperator;

@FunctionalInterface
public interface BinOp<T> extends BinFunction<T, T, T>, BinaryOperator<T> {
}
