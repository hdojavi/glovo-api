package com.jhernando.glovo.model.services;


import com.jhernando.glovo.model.domain.Business;
import com.jhernando.glovo.model.domain.OrderBusi;
import com.jhernando.glovo.model.repositories.IBusinessRepository;
import com.jhernando.glovo.model.repositories.IOrderBusiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService implements IService<Business, Long> {

    @Autowired
    private IBusinessRepository businessRepository;

    @Override
    public List<Business> findAll() {
        return businessRepository.findAll();
    }

    @Override
    public Business findById(Long id) {
        return businessRepository.findById(id).orElse(null);
    }

    @Override
    public Business save(Business business) {
        Business businessToBeUpdated;

        if (business.getId() == null) {
            businessToBeUpdated = business;
        } else {
            businessToBeUpdated = businessRepository.findById(business.getId()).orElse(null);
        }
        return businessRepository.save(businessToBeUpdated);
    }

    @Override
    public void delete(Long id) {
        businessRepository.deleteById(id);
    }

    public List<Business> findByCategoryId(Long id) {
        return businessRepository.findBusinessesByBusinessCategory_Id(id);
    }
}
