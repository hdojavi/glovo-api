package com.jhernando.glovo.controllers;

import com.jhernando.glovo.model.domain.Business;
import com.jhernando.glovo.model.domain.OrderLine;
import com.jhernando.glovo.model.services.BusinessService;
import com.jhernando.glovo.model.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/businesses")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping
    public List<Business> findAll() {
        return businessService.findAll();
    }

    @GetMapping("/{id}")
    public Business findById(@PathVariable Long id) {
        return businessService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Business insert(@RequestBody Business business) {
        return businessService.save(business);
    }

    @PutMapping
    public Business update(@RequestBody Business business) {
        return businessService.save(business);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        businessService.delete(id);
    }

    @GetMapping("/category/{id}")
    public List<Business> findByCategoryId(@PathVariable Long id) {
        return businessService.findByCategoryId(id);
    }
}
