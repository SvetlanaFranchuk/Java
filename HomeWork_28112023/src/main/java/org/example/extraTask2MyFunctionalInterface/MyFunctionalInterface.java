package org.example.extraTask2MyFunctionalInterface;

@FunctionalInterface
public interface MyFunctionalInterface<T,R> {
    R execute(T a, T b, T c);
}
