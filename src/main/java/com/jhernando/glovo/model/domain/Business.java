package com.jhernando.glovo.model.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Table(name = "business")
@Entity
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    private String name;

    @Size(max = 250)
    private String description;

    private float shippingprice;

    private int rate;

    private int kmaway;

    @Size(max = 1000)
    private String thumb;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "businesscategoryid")
    @NotNull
    private BusinessCategory businessCategory;
}
