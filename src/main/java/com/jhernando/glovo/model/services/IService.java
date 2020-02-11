package com.jhernando.glovo.model.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IService<Entity, Id> {

    List<Entity> findAll();

    Entity findById(Id id);

    Entity save(Entity entity);

    void delete(Id id);
}
