package com.example.webbanquanao.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cart")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total")
    private Float total;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name ="product_id")
    private Long productId;

    @Column(name="quanTiTy")
    private Long quanTiTy;

}
