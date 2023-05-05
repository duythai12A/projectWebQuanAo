package com.example.webbanquanao.service;

import com.example.webbanquanao.entity.Cart;

import java.util.Collection;

public interface ShoppingCartService {
    void add(Cart item);


    void remove(Long id);

    Cart update(Long proId, Long quanTiTy);

    void clear();

    Collection<Cart> getAll();

    int getCount();

    double getAmount();
}
