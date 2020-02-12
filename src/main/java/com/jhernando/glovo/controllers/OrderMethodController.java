package com.jhernando.glovo.controllers;

import com.jhernando.glovo.model.domain.OrderBusi;
import com.jhernando.glovo.model.domain.OrderMethod;
import com.jhernando.glovo.model.services.OrderBusiService;
import com.jhernando.glovo.model.services.OrderMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ordermethods")
public class OrderMethodController {

    @Autowired
    private OrderMethodService orderMethodService;

    @GetMapping
    public List<OrderMethod> findAll() {
        return orderMethodService.findAll();
    }

    @GetMapping("/{id}")
    public OrderMethod findById(@PathVariable Long id) {
        return orderMethodService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderMethod insert(@RequestBody OrderMethod ordermethod) {
        return orderMethodService.save(ordermethod);
    }

    @PutMapping
    public OrderMethod update(@RequestBody OrderMethod ordermethod) {
        return orderMethodService.save(ordermethod);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        orderMethodService.delete(id);
    }

}
