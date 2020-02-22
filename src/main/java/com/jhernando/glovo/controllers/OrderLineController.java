package com.jhernando.glovo.controllers;

import com.jhernando.glovo.model.domain.OrderLine;
import com.jhernando.glovo.model.domain.User;
import com.jhernando.glovo.model.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orderdetails")
public class OrderLineController {

    @Autowired
    private OrderLineService orderLineService;

    @GetMapping
    public List<OrderLine> findAll() {
        return orderLineService.findAll();
    }

    @GetMapping("/{id}")
    public OrderLine findById(@PathVariable Long id) {
        return orderLineService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderLine insert(@RequestBody OrderLine orderDetail) {
        return orderLineService.save(orderDetail);
    }

    @PutMapping
    public OrderLine update(@RequestBody OrderLine orderDetail) {
        return orderLineService.save(orderDetail);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        orderLineService.delete(id);
    }

    @GetMapping("/order/{id}")
    public List<OrderLine> findAllByOrderBusi_Id(@PathVariable Long id) {
        return orderLineService.findAllByOrderBusi_Id(id);
    }
}
