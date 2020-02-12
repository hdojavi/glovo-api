package com.jhernando.glovo.model.services;


import com.jhernando.glovo.model.domain.Business;
import com.jhernando.glovo.model.domain.BusinessCategory;
import com.jhernando.glovo.model.repositories.IBusinessCategoryRepository;
import com.jhernando.glovo.model.repositories.IBusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessCategoryService implements IService<BusinessCategory, Long> {

    @Autowired
    private IBusinessCategoryRepository businessCategoryRepository;

    @Override
    public List<BusinessCategory> findAll() {
        return businessCategoryRepository.findAll();
    }

    @Override
    public BusinessCategory findById(Long id) {
        return businessCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public BusinessCategory save(BusinessCategory business) {
        BusinessCategory businessToBeUpdated;

        if (business.getId() == null) {
            businessToBeUpdated = business;
        } else {
            businessToBeUpdated = businessCategoryRepository.findById(business.getId()).orElse(null);
        }
        return businessCategoryRepository.save(businessToBeUpdated);
    }

    @Override
    public void delete(Long id) {
        businessCategoryRepository.deleteById(id);
    }

}
