package com.foodie.foodcatalogue.Entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String empname;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "depid", nullable = false)
    private Department department;

}
