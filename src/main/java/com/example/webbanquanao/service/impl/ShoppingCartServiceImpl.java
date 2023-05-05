package com.example.webbanquanao.service.impl;

import com.example.webbanquanao.entity.Cart;
import com.example.webbanquanao.repository.ProductRepository;
import com.example.webbanquanao.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ProductRepository productRepository;
    Map<Long, Cart> maps = new HashMap<>();

    public void add(Cart item){
        Cart cart = maps.get(item.getProductId());
        if(cart == null){
            maps.put(item.getProductId(), item);
        } else {
            cart.setQuanTiTy(cart.getQuanTiTy()+1);
        }
    }

    public void remove(Long id){
        maps.remove(id);
    }

    public Cart update(Long proId, Long quanTiTy) {
        Cart cart = maps.get(proId);
        cart.setQuanTiTy(quanTiTy);
        return cart;
    }

    public void clear(){
        maps.clear();
    }

    public Collection<Cart> getAll(){
        return maps.values();
    }

    public int getCount(){
        return  maps.values().size();
    }

    public double getAmount() {

        return maps.values().stream()
                .mapToDouble(item -> item.getQuanTiTy() * productRepository.findById(item.getProductId()).get().getPrice())
                .sum();
    }
}
