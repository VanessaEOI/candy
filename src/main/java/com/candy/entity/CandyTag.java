package com.candy.entity;

import jakarta.persistence.*;

@Entity
public class CandyTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candyTagId;
    @Enumerated(EnumType.STRING) // Indique que l'attribut est un enum représenté par une chaîne de caractères
    private CandyTagEnum candyTagName;

    // Constructeurs, getters, setters, et méthode toString
}