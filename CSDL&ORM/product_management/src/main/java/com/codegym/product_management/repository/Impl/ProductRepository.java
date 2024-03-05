package com.codegym.product_management.repository.Impl;

import com.codegym.product_management.model.Product;
import com.codegym.product_management.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {
    private List<Product> productList;
    @Override
    public List<Product> findAll() {
        productList = BaseRepository.entityManager.createQuery("select p from Product p", Product.class).getResultList();
        return productList;
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.createQuery("select p from Product p where p.id = :id", Product.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void update( Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public boolean remove(int id) {
        Product product = findById(id);
        if (product != null){
            EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
            entityTransaction.begin();
            BaseRepository.entityManager.remove(product);
            entityTransaction.commit();
            return true;
        }
        return false;
    }
}
