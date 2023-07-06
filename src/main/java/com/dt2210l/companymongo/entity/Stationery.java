package com.dt2210l.companymongo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Stationery {

    @Id
    @GeneratedValue
    private Integer id;

    private String item;

    private String material;

    private double dimension1;

    private double dimension2;

    private int stock;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stationery")
    private Set<Color> colors;

}
