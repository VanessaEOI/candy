package com.candy.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemCandyBox {

    @EmbeddedId
    private ItemCandyBoxId id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "candy_id", insertable = false, updatable = false)
    private Candy candy;

    // Constructeurs, getters, setters, et méthode toString
}