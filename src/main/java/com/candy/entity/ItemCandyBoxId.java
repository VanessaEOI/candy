package com.candy.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ItemCandyBoxId implements Serializable {

    private static final long serialVersionUID = 1L;

    // Ajouter cette association avec CandyBox
    @ManyToOne
    @JoinColumn(name = "candybox_id")
    private CandyBox candyBox;

    private String candyColorName;

    public CandyBox getCandyBox() {
        return candyBox;
    }

    public void setCandyBox(CandyBox candyBox) {
        this.candyBox = candyBox;
    }

    public String getCandyColorName() {
        return candyColorName;
    }

    public void setCandyColorName(String candyColorName) {
        this.candyColorName = candyColorName;
    }
}
