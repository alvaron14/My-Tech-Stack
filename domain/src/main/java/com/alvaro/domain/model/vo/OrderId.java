package com.alvaro.domain.model.vo;

import com.alvaro.domain.ddd.ValueObject;
import org.jmolecules.ddd.types.Identifiable;

public record OrderId(Integer value) implements ValueObject<Integer> {


}
