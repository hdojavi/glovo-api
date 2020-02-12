package com.jhernando.glovo.controllers;

import com.jhernando.glovo.model.domain.Business;
import com.jhernando.glovo.model.domain.BusinessCategory;
import com.jhernando.glovo.model.services.BusinessCategoryService;
import com.jhernando.glovo.model.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/businesscategories")
public class BusinessCategoryController {

    @Autowired
    private BusinessCategoryService businessCategoryService;

    @GetMapping
    public List<BusinessCategory> findAll() {
        return businessCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public BusinessCategory findById(@PathVariable Long id) {
        return businessCategoryService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BusinessCategory insert(@RequestBody BusinessCategory businessCategory) {
        return businessCategoryService.save(businessCategory);
    }

    @PutMapping
    public BusinessCategory update(@RequestBody BusinessCategory businessCategory) {
        return businessCategoryService.save(businessCategory);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        businessCategoryService.delete(id);
    }

}
