package com.alvaro.infrastructure.rest.controller;

import com.alvaro.domain.model.Order;
import com.alvaro.domain.projection.Pagination;
import com.alvaro.framework.ddd.core.FromValueObject;
import com.alvaro.framework.ddd.mapper.ValueObjectMapper;
import com.alvaro.infrastructure.rest.api.dto.OrderDTO;
import com.alvaro.infrastructure.rest.api.dto.OrderSearchResultDTO;
import com.alvaro.infrastructure.rest.api.dto.PaginationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = ValueObjectMapper.class)
public interface OrderApiMapper {

    @Mapping(target = "data", source = "source")
    OrderSearchResultDTO toResponse(List<Order> source, Pagination pagination);

    @Mapping(target = "id", qualifiedBy = FromValueObject.class)
    OrderDTO toResponse(Order source);

    PaginationDTO toResponse(Pagination source);

}
