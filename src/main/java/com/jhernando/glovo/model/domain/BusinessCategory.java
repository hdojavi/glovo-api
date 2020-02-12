package com.jhernando.glovo.model.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Table(name = "businesscategory")
@Entity
public class BusinessCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 30)
    private String category;

    @JsonIgnore
    @OneToMany(mappedBy = "businessCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Business> business;

}
