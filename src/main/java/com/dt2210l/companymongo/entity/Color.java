package com.dt2210l.companymongo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Color {

    @Id
    @GeneratedValue
    private Integer id;

    private String color;

    @ManyToOne(optional = false)
    @JoinColumn(name = "stationery_id")
    private Stationery stationery;

}
