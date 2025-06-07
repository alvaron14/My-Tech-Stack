package com.alvaro.infrastructure.model.order;

import com.alvaro.domain.model.Order;
import com.alvaro.framework.ddd.core.ToValueObject;
import com.alvaro.framework.ddd.mapper.ValueObjectMapper;
import com.alvaro.infrastructure.model.order.entity.OrderJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = ValueObjectMapper.class)
public interface OrderMapper {

  @Mapping(target = "id", qualifiedBy = ToValueObject.class)
  Order toDomain(OrderJpaEntity entity);

  void updateEntity(@MappingTarget OrderJpaEntity entity, Order domain);

}
