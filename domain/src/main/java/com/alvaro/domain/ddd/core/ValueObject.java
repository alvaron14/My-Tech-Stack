package com.alvaro.domain.ddd.core;

@org.jmolecules.ddd.annotation.ValueObject
public interface ValueObject<T> {

    T value();
}
