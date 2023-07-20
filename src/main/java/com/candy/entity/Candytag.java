package com.candy.entity;

import jakarta.persistence.*;

@Entity
public class Candytag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candytagId;
    @Enumerated(EnumType.STRING) // Indique que l'attribut est un enum représenté par une chaîne de caractères
    private CandytagEnum candytagName;

    // Constructeurs, getters, setters, et méthode toString
}