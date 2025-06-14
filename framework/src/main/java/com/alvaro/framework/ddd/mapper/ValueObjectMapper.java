package com.alvaro.framework.ddd.mapper;

import com.alvaro.framework.ddd.core.FromValueObject;
import com.alvaro.framework.ddd.core.ToValueObject;
import com.alvaro.framework.ddd.core.ValueObject;
import lombok.SneakyThrows;
import org.mapstruct.Mapper;
import org.mapstruct.TargetType;

@Mapper
public interface ValueObjectMapper {

  @FromValueObject
  default <V extends ValueObject<T>, T> T fromValueObject(final V valueObject) {
    return valueObject == null ? null : valueObject.value();
  }

  @SneakyThrows
  @ToValueObject
  default <V extends ValueObject<T>, T> V toValueObject(final T value, @TargetType final Class<V> valueObjectClass) {
    if (value == null) {
      return null;
    }
    return valueObjectClass.getDeclaredConstructor(value.getClass()).newInstance(value);

  }

}