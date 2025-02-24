package com.alvaro.domain.ddd;

@org.jmolecules.ddd.annotation.ValueObject
public interface ValueObject<T> {

    T value();
}
