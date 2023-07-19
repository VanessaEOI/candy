package com.candy.entity;

import jakarta.persistence.*;

@Entity
public class CandyBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candyBoxId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private CustomerOrder customerOrder;

    // Constructeurs, getters, setters, et méthode toString
}