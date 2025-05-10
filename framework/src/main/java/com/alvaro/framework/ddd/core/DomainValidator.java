package com.alvaro.framework.ddd.core;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.Objects;

public class DomainValidator<T extends DomainValidator<?>> {

  @Getter(AccessLevel.PROTECTED)
  private final T myself;

  @Getter(AccessLevel.PROTECTED)
  private final String name;

  private final Object value;

  @SuppressWarnings("unchecked")
  protected DomainValidator(final String name, final Object value, Class<?> selfType) {
    this.name = name;
    this.value = value;
    this.myself = (T) selfType.cast(this);
  }

  /**
   * Domain Validator factory method.
   *
   * @param name  The name of the field
   * @param value The field object value
   * @return A new DomainValidator instance if pass the validation or throw DomainError if not
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static DomainValidator validator(final String name, final Object value) {
    return new DomainValidator(name, convert(value), DomainValidator.class);
  }

  protected static Object convert(final Object value) {
    return switch (value) {
      case ValueObject<?> voValue -> voValue.value();
      case null, default -> value;
    };
  }

  public T isRequired() {
    if (Objects.isNull(this.value)) {
      throw new DomainError(this.name + " is required");
    }

    return this.myself;
  }
}