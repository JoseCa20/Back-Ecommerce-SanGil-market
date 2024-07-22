package com.sangil_market.virtual.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class User {

    @Id
    private Long id;

    private String username;

    private String address;

    private String email;

    private String password;

    private String phone;

    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CashOrder> cashOrders;
}
