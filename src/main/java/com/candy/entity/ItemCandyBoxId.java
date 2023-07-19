package com.candy.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ItemCandyBoxId implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "candy_id")
    private Candy candy;

    @ManyToOne
    @JoinColumn(name = "candybox_id")
    private CandyBox candyBox;

    // Constructeurs, getters, setters, et méthode equals() et hashCode

    // ...
}