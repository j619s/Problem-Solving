package com.java.concepts.lambdas;

@FunctionalInterface
public interface Operation<T> {

    T opearate(T value1, T value2);

}
