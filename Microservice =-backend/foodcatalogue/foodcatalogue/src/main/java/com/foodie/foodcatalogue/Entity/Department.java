package com.foodie.foodcatalogue.Entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int depid;
    private String depname;
    private String depdesc;


}
