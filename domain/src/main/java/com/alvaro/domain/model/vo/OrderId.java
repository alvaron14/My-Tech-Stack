package com.alvaro.domain.model.vo;

import com.alvaro.framework.ddd.core.AggregateRootId;

import java.util.UUID;

public record OrderId(UUID value) implements AggregateRootId<UUID> {

}
