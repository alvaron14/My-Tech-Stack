package com.alvaro.infrastructure.model.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class OrderJpaEntity {

  @Id
  //@GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
}
