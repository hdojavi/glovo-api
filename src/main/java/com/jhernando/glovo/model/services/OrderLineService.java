package com.jhernando.glovo.model.services;


import com.jhernando.glovo.model.domain.OrderBusi;
import com.jhernando.glovo.model.domain.OrderLine;
import com.jhernando.glovo.model.repositories.IOrderBusiRepository;
import com.jhernando.glovo.model.repositories.IOrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService implements IService<OrderLine, Long> {

    @Autowired
    private IOrderLineRepository orderLineRepository;

    @Override
    public List<OrderLine> findAll() {
        return orderLineRepository.findAll();
    }

    @Override
    public OrderLine findById(Long id) {
        return orderLineRepository.findById(id).orElse(null);
    }

    @Override
    public OrderLine save(OrderLine orderLine) {
        OrderLine orderLineToBeUpdated;

        if (orderLine.getId() == null) {
            orderLineToBeUpdated = orderLine;
        } else {
            orderLineToBeUpdated = orderLineRepository.findById(orderLine.getId()).orElse(null);
        }
        return orderLineRepository.save(orderLineToBeUpdated);
    }

    @Override
    public void delete(Long id) {
        orderLineRepository.deleteById(id);
    }

    public List<OrderLine> findAllByOrderBusi_Id(Long id) {
        return orderLineRepository.findAllByOrderBusi_Id(id);
    }
}
