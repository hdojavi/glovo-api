package com.jhernando.glovo.model.repositories;

import com.jhernando.glovo.model.domain.Business;
import com.jhernando.glovo.model.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBusinessRepository extends JpaRepository<Business, Long> {
}
