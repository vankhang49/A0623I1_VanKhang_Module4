package com.codegym.product_management.service.serviceImpl;

import com.codegym.product_management.model.Product;
import com.codegym.product_management.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService implements IProductService {
    private static final List<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "TShirt", 4.3, "Loose form, loose sleeves", "Gucci"));
        productList.add(new Product(2, "Trousers", 6, "Long and tight fit", "Nike"));
        productList.add(new Product(3, "Jeans", 10.5, "It's pants, not a shirt", "Chanel"));
        productList.add(new Product(4, "Cardigan", 7, "Fashionable and stylish", "Dior"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id-1);
    }

    @Override
    public void update(int id, Product product) {
        Product p = findById(id);
        if (p != null){
            productList.remove(p);
            productList.add(product);
        }
    }

    @Override
    public boolean remove(int id) {
        Product p = productList.remove(id-1);
        if (p != null){
            return true;
        }
        return false;
    }
}
