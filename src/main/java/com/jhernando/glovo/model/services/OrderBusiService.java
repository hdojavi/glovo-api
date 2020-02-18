package com.jhernando.glovo.model.services;


import com.jhernando.glovo.model.domain.OrderBusi;
import com.jhernando.glovo.model.domain.User;
import com.jhernando.glovo.model.repositories.IOrderBusiRepository;
import com.jhernando.glovo.model.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBusiService implements IService<OrderBusi, Long> {

    @Autowired
    private IOrderBusiRepository orderBusiRepository;

    @Override
    public List<OrderBusi> findAll() {
        return orderBusiRepository.findAll();
    }

    @Override
    public OrderBusi findById(Long id) {
        return orderBusiRepository.findById(id).orElse(null);
    }

    @Override
    public OrderBusi save(OrderBusi order) {
        OrderBusi orderToBeUpdated;

        if (order.getId() == null) {
            orderToBeUpdated = order;
        } else {
            orderToBeUpdated = orderBusiRepository.findById(order.getId()).orElse(null);
        }
        return orderBusiRepository.save(orderToBeUpdated);
    }

    @Override
    public void delete(Long id) {
        orderBusiRepository.deleteById(id);
    }

    public List<OrderBusi> findOrdersByUser(Long id) {
        return orderBusiRepository.findAllByUser_Id(id);
    }
}
