package com.candy.entity;

import jakarta.persistence.*;

@Entity
public class Candytag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candytagId;
    @Enumerated(EnumType.STRING)
    private CandytagEnum candytagName;

}