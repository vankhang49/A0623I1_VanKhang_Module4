package com.codegym.customer_province.repository;

import com.codegym.customer_province.model.Customer;
import com.codegym.customer_province.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends PagingAndSortingRepository<Province, Long> ,
        CrudRepository<Province, Long> {
}