package com.candy.entity;

import jakarta.persistence.*;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int orderCandyQty;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "candyTag_id")
    private CandyTag candyTag;

    // Constructeurs, getters, setters, et méthode toString
}