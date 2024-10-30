package io.CodeForAll.fanstatics;
@FunctionalInterface
public interface BiOperation<T> {
    T execute(T operand1, T operand2);
}
