package com.jhernando.glovo.controllers;

import com.jhernando.glovo.model.domain.OrderBusi;
import com.jhernando.glovo.model.domain.User;
import com.jhernando.glovo.model.services.OrderBusiService;
import com.jhernando.glovo.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderBusiController {

    @Autowired
    private OrderBusiService orderBusiService;

    @GetMapping
    public List<OrderBusi> findAll() {
        return orderBusiService.findAll();
    }

    @GetMapping("/{id}")
    public OrderBusi findById(@PathVariable Long id) {
        return orderBusiService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderBusi insert(@RequestBody OrderBusi order) {
        return orderBusiService.save(order);
    }

    @PutMapping
    public OrderBusi update(@RequestBody OrderBusi order) {
        return orderBusiService.save(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        orderBusiService.delete(id);
    }

}
