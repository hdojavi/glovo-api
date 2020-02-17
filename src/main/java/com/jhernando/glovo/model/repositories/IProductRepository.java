package com.jhernando.glovo.model.repositories;

import com.jhernando.glovo.model.domain.OrderBusi;
import com.jhernando.glovo.model.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByBusiness_Id(Long id);
}
