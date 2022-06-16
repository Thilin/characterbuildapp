package com.example.characterbuilderapp.utils;

@FunctionalInterface
public interface Processor<T, U> {

    U process(T t);
}
