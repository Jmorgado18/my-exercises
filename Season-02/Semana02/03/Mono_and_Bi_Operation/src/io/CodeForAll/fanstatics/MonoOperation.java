package io.CodeForAll.fanstatics;


@FunctionalInterface
public interface MonoOperation<T> {
    T execute(T operand);
}
