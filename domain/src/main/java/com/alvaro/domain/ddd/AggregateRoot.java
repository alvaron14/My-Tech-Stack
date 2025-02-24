package com.alvaro.domain.ddd;

public abstract class AggregateRoot<T> implements ValueObject<T> {

    private T id;

    @Override
    public T value() {
        return id;
    }

}
