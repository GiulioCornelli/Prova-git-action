package com.ttf.service;

import com.ttf.data.Product;
import com.ttf.repository.ProductRepo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {

    @Autowired private ProductRepo repo;

    public List<Product> gettAll() {
        return repo.findAll();
    }

    public boolean InsertOne(Product p) {
        boolean result = false;
        // .save() fa due cose:
        // Se l'ID è nullo, fa una INSERT.
        // Se l'ID esiste già, fa una UPDATE.
        try {
            repo.save(p);
            result = true;
        } catch (Exception e) {
            System.out.print(e);
        }
        return result;
    }

    public Product getByName(String name) {
        return repo.findByName(name);
    }
}
