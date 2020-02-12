package com.jhernando.glovo.model.repositories;

import com.jhernando.glovo.model.domain.Business;
import com.jhernando.glovo.model.domain.BusinessCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBusinessCategoryRepository extends JpaRepository<BusinessCategory, Long> {
}
