package com.dt2210l.companymongo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Salary {

    @Id
    @GeneratedValue
    private Integer id;

    private String type;

    private int amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Salary salary = (Salary) o;
        return getId() != null && Objects.equals(getId(), salary.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
