package com.jhernando.glovo.model.repositories;

import com.jhernando.glovo.model.domain.OrderLine;
import com.jhernando.glovo.model.domain.OrderMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderMethodRepository extends JpaRepository<OrderMethod, Long> {
}
