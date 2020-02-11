package com.jhernando.glovo.model.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Table(name = "orderline")
@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private int productid;

    @NotEmpty
    private String productname;

    private int quantity;

    private float price;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "orderid")
    @NotNull
    private OrderBusi orderBusi;
}
