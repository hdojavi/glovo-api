package com.jhernando.glovo.model.services;


import com.jhernando.glovo.model.domain.OrderLine;
import com.jhernando.glovo.model.domain.OrderMethod;
import com.jhernando.glovo.model.repositories.IOrderLineRepository;
import com.jhernando.glovo.model.repositories.IOrderMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderMethodService implements IService<OrderMethod, Long> {

    @Autowired
    private IOrderMethodRepository orderMethodRepository;

    @Override
    public List<OrderMethod> findAll() {
        return orderMethodRepository.findAll();
    }

    @Override
    public OrderMethod findById(Long id) {
        return orderMethodRepository.findById(id).orElse(null);
    }

    @Override
    public OrderMethod save(OrderMethod orderMethod) {
        OrderMethod orderMethodToBeUpdated;

        if (orderMethod.getId() == null) {
            orderMethodToBeUpdated = orderMethod;
        } else {
            orderMethodToBeUpdated = orderMethodRepository.findById(orderMethod.getId()).orElse(null);
        }
        return orderMethodRepository.save(orderMethodToBeUpdated);
    }

    @Override
    public void delete(Long id) {
        orderMethodRepository.deleteById(id);
    }

}
