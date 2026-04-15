package com.ttf.repository;

import com.ttf.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {

    public Product findByName(String name);
}
