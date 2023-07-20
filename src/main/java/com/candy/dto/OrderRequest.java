package com.candy.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private String candytagName;
    private int quantity;

    public String getCandytagName() {
        return candytagName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCandytagName(String candytagName) {
        this.candytagName = candytagName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}