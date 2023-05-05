package com.example.webbanquanao.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "price")
    private Float price;

    @Column(name = "description")
    private String description;

    @Column(name="image")
    private String Image;

//    @ManyToOne
//    @JoinColumn(name = "categoryId")
//    private category category;
//
//    @ManyToOne
//    @JoinColumn(name = "supplierId")
//    private supplier supplier;
}
