package com.codegym.product_management.repository;

import com.codegym.product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);

    Product findById(int id);

    void update(Product product);

    boolean remove(int id);
}
