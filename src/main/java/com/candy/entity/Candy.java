package com.candy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Candy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candyId;
    private String candyColor;

    // Constructeurs, getters, setters, et méthode toString
}
