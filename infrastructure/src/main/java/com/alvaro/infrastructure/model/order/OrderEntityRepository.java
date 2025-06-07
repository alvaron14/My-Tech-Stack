package com.alvaro.infrastructure.model.order;

import com.alvaro.infrastructure.model.order.entity.OrderJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderJpaEntity, UUID> {

}
