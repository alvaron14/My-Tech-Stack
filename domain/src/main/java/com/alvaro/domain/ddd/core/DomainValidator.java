package com.alvaro.domain.ddd.core;

import com.alvaro.domain.ddd.core.vo.LocalDateVO;
import lombok.AccessLevel;
import lombok.Getter;

import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Objects;
import java.util.regex.Pattern;

public class DomainValidator<T extends DomainValidator<?>> {

  private static final String URN_SPLITTER_PATTERN = ":(?=[^:]*$)";

  private static final Pattern UUID_REGEX =
      Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");

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
   * @param name The name of the field
   * @param value The field object value
   * @return A new DomainValidator instance if pass the validation or throw DomainError if not
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static DomainValidator validator(final String name, final Object value) {
    return new DomainValidator(name, convert(value), DomainValidator.class);
  }

  protected static Object convert(final Object value) {
    return switch (value) {
      case LocalDateVO ldValue -> ldValue;
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

  public T isNotBlank() {
    this.isRequired();
    if (this.value instanceof String stringValue) {
      if (stringValue.isBlank()) {
        throw new DomainError(this.name + " cannot be blank");
      }
    } else {
      throw new DomainError("isNotBlank is only allowed for String type");
    }

    return this.myself;
  }

  public T hasSizeLessThan(final int maxSize) {
    if (Objects.isNull(this.value)) {
      return this.myself;
    }
    if (this.value instanceof String stringValue) {
      if (stringValue.length() > maxSize) {
        throw new DomainError(this.name + " must be less than " + maxSize + " characters");
      }
    } else {
      throw new DomainError("hasSizeLessThan is only allowed for String type");
    }

    return this.myself;
  }

  @SuppressWarnings("rawtypes")
  public T isNotEmpty() {
    this.isRequired();
    if (this.value instanceof Collection collection) {
      if (collection.isEmpty()) {
        throw new DomainError(this.name + " must be not empty");
      }
    } else {
      throw new DomainError("isNotEmpty is only allowed for Collection type");
    }

    return this.myself;
  }

  public T isURNOfType(final String type) {
    if (Objects.isNull(this.value)) {
      return this.myself;
    }
    if (this.value instanceof String stringValue) {
      final String[] urn = stringValue.split(URN_SPLITTER_PATTERN);
      if (!urn[0].equals(type)) {
        throw new DomainError(this.name + " must be type of " + type);
      }
      if (!UUID_REGEX.matcher(urn[1]).matches()) {
        throw new DomainError(this.name + " urn ID must be an UUID");
      }
    } else {
      throw new DomainError("isURN is only allowed for String type");
    }

    return this.myself;
  }

  public T isBeforeOrEqual(final LocalDateVO endDate) {
    if (Objects.isNull(this.value)) {
      return this.myself;
    }
    if (this.value instanceof LocalDateVO localDateValue) {
      if (!localDateValue.isBeforeOrEqual(endDate)) {
        throw new DomainError(this.name + " must be before " + endDate.value());
      }
    } else {
      throw new DomainError("isBeforeOrEqual is only allowed for LocalDateVO type");
    }

    return this.myself;
  }

  public T isPositive() {
    if (Objects.isNull(this.value)) {
      return this.myself;
    }
    if (this.value instanceof Number numberValue) {
      if (numberValue.doubleValue() <= 0) {
        throw new DomainError(this.name + " must be positive");
      }
    } else {
      throw new DomainError("isPositive is only allowed for Number type");
    }

    return this.myself;
  }

  public T isPositiveOrZero() {
    if (Objects.isNull(this.value)) {
      return this.myself;
    }
    if (this.value instanceof Number number) {
      if (number.doubleValue() < 0) {
        throw new DomainError(this.name + " must be positive or zero");
      }
    } else {
      throw new DomainError("isPositiveOrZero is only allowed for Number type");
    }

    return this.myself;
  }

  public T isNotZeroIf(boolean condition) {
    if (Objects.isNull(this.value)) {
      return this.myself;
    }
    if (this.value instanceof Number number) {
      if (number.doubleValue() == 0 && condition) {
        throw new DomainError(this.name + " cannot be zero");
      }
    } else {
      throw new DomainError("isNotZeroIf is only allowed for Number type");
    }

    return this.myself;
  }

  public T isBetween(final int min, final int max) {
    if (Objects.isNull(this.value)) {
      return this.myself;
    }
    switch (this.value) {
      case Integer intValue when (intValue < min || intValue > max) ->
          throw new DomainError(this.name + " must be between " + min + " and " + max);
      case Integer ignored -> {
        //Validation passed
      }
      case String stringValue -> {
        final int length = stringValue.length();
        if (min > length || length > max) {
          throw new DomainError(this.name + " length must be between " + min + " and " + max);
        }
      }
      default -> throw new DomainError("isBetween is only allowed for Integer and String types");
    }

    return this.myself;
  }

  public T hasMaxRange(final LocalDateVO endDate, final ChronoUnit chronoUnit, final int amount) {
    if (this.value instanceof LocalDateVO dateRangeComparableValue) {
      if (!dateRangeComparableValue.hasMaxRange(endDate, chronoUnit, amount)) {
        throw new DomainError(this.name + " must be " + amount + " " + chronoUnit + " or less with " + endDate.value());
      }
    } else {
      throw new DomainError("hasMaxRange is only allowed for LocalDateVO type");
    }

    return this.myself;
  }

}