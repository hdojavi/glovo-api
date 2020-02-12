package com.jhernando.glovo.model.services;


import com.jhernando.glovo.model.domain.BusinessCategory;
import com.jhernando.glovo.model.domain.Product;
import com.jhernando.glovo.model.repositories.IBusinessCategoryRepository;
import com.jhernando.glovo.model.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IService<Product, Long> {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product business) {
        Product businessToBeUpdated;

        if (business.getId() == null) {
            businessToBeUpdated = business;
        } else {
            businessToBeUpdated = productRepository.findById(business.getId()).orElse(null);
        }
        return productRepository.save(businessToBeUpdated);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
