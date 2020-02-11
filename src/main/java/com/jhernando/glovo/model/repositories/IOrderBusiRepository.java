package com.jhernando.glovo.model.repositories;

import com.jhernando.glovo.model.domain.OrderBusi;
import com.jhernando.glovo.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderBusiRepository extends JpaRepository<OrderBusi, Long> {
}
