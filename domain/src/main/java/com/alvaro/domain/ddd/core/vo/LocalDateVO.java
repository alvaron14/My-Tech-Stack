package com.alvaro.domain.ddd.core.vo;

import com.alvaro.domain.ddd.core.ValueObject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public interface LocalDateVO extends ValueObject<LocalDate>, Comparable<LocalDateVO> {

  default boolean isBeforeOrEqual(LocalDateVO date) {
    if (date == null) {
      return true;
    }

    return this.value().isEqual(date.value()) || this.value().isBefore(date.value());
  }

  default boolean hasMaxRange(final LocalDateVO date, final ChronoUnit chronoUnit, final int amount) {
    if (date == null) {
      return true;
    }
    final var unitsBetween = chronoUnit.between(this.value(), date.value());
    return unitsBetween >= 0 && unitsBetween <= amount;
  }

  @Override
  default int compareTo(LocalDateVO o) {
    return this.value().compareTo(o.value());
  }
}