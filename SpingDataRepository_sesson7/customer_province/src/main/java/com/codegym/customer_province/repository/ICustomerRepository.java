package com.codegym.customer_province.repository;

import com.codegym.customer_province.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long>,
        CrudRepository<Customer, Long>{
    @Query(value = "select customers.*, provinces.province_name from customers join provinces on customers.province_id = provinces.province_id where province_name like :province ", nativeQuery = true)
    Page<Customer> searchByProvince(@Param("province")String province, Pageable pageable);

}

