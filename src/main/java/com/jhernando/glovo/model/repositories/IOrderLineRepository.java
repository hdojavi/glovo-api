package com.jhernando.glovo.model.repositories;

import com.jhernando.glovo.model.domain.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderLineRepository extends JpaRepository<OrderLine, Long> {
}
