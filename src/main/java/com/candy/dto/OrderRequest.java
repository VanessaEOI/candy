package com.candy.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private String candytagName;
    private int quantity;

}