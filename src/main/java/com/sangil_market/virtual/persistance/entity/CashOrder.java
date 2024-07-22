package com.sangil_market.virtual.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class CashOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private Double total;

    private String state;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cashOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

}
