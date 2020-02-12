package com.jhernando.glovo.model.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Table(name = "product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    private String name;

    @Size(max = 250)
    private String description;

    private float price;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "businessid")
    @NotNull
    private Business business;
}
