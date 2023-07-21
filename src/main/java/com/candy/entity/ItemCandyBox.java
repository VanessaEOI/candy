package com.candy.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class ItemCandyBox implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ItemCandyBoxId id;

    private int quantity;

    // Ajouter cette association avec CandyBox
    @ManyToOne
    @JoinColumn(name = "candybox_id", insertable = false, updatable = false)
    private CandyBox candyBox;

    public ItemCandyBoxId getId() {
        return id;
    }

    public void setId(ItemCandyBoxId id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CandyBox getCandyBox() {
        return candyBox;
    }

    public void setCandyBox(CandyBox candyBox) {
        this.candyBox = candyBox;
    }

    // Ajoutez cette méthode pour définir la couleur du bonbon dans la CandyBox
    public void setCandyColorName(String color) {
        if (id == null) {
            id = new ItemCandyBoxId();
        }
        id.setCandyColorName(color);
    }
}
