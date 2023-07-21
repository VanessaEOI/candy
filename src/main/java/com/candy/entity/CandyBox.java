package com.candy.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class CandyBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candyBoxId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private CustomerOrder customerOrder;

    @OneToMany(mappedBy = "candyBox", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCandyBox> itemCandyBoxes;

    public List<ItemCandyBox> getItemCandyBoxes() {
        return itemCandyBoxes;
    }

    public void setItemCandyBoxes(List<ItemCandyBox> itemCandyBoxes) {
        this.itemCandyBoxes = itemCandyBoxes;
    }

    // Ajoutez cette méthode pour définir les couleurs des bonbons dans la CandyBox
    public void setCandyColors(List<String> candyColors) {
        List<ItemCandyBox> items = candyColors.stream()
                .map(color -> {
                    ItemCandyBox item = new ItemCandyBox();
                    item.setCandyBox(this);
                    item.setCandyColorName(color); // Utilisez la méthode pour définir la couleur du bonbon
                    return item;
                })
                .collect(Collectors.toList());

        this.itemCandyBoxes = items;
    }

    // Le reste du code de la classe CandyBox...
}