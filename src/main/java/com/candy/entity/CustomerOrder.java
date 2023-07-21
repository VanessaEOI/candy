package com.candy.entity;

import jakarta.persistence.*;

import java.util.List;

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
    private Candytag candytag;

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CandyBox> candyBoxes;

    public List<CandyBox> getCandyBoxes() {
        return candyBoxes;
    }

    public void setCandyBoxes(List<CandyBox> candyBoxes) {
        this.candyBoxes = candyBoxes;
    }

    public void setOrderCandyQty(int quantity) {
    }
}