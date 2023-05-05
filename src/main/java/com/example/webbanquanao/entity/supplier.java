package com.example.webbanquanao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supplier")
@Data
public class supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
//    @OneToMany(mappedBy = "Product")
//    private Collection<Product> products;

}
