package com.jhernando.glovo.model.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Table(name = "orderbusi")
@Entity
public class OrderBusi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 20)
    private String orderdate;

    private float pricetotal;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userid")
    @NotNull
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ordermethod")
    @NotNull
    private OrderMethod orderMethod;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "businessid")
    @NotNull
    private Business business;

    @JsonIgnore
    @OneToMany(mappedBy = "orderBusi", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderLine> orderlines;
}
