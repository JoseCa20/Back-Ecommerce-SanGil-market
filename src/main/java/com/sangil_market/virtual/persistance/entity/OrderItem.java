package com.sangil_market.virtual.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private CashOrder cashOrder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
