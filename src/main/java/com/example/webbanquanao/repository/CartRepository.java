package com.example.webbanquanao.repository;

import com.example.webbanquanao.entity.Cart;
import com.example.webbanquanao.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
