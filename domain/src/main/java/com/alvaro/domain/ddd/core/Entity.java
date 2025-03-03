package com.alvaro.domain.ddd.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import static com.alvaro.domain.ddd.core.DomainValidator.validator;

@Getter
@EqualsAndHashCode
@ToString
public abstract class Entity<I extends EntityId<?>> {
  private final I id;

  protected Entity(final I id) {
    validator("id", id).isRequired();
    this.id = id;
  }

  /**
   * Check if two entities are equal. Two entities are considered equal if they are the same entity and have the same type and id.
   *
   * <p>NOTE: For object equality, please use {@link #equals(Object)}</p>
   *
   * @param other Other entity
   * @return true if the entity are the same and have the same type and id, false otherwise
   */

  public boolean isEqualTo(final Entity<I> other) {
    if (!(this.getClass().isAssignableFrom(other.getClass()) || other.getClass().isAssignableFrom(this.getClass()))) {
      return false;
    }
    return this.id.equals(other.id);
  }
}
