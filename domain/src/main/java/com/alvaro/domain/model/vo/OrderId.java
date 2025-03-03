package com.alvaro.domain.model.vo;

import com.alvaro.domain.ddd.AggregateRootId;
import com.alvaro.domain.ddd.ValueObject;
import org.jmolecules.ddd.types.Identifiable;

import java.util.UUID;

public record OrderId(UUID value) implements AggregateRootId<UUID> {

}
