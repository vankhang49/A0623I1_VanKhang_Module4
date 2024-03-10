package com.codegym.customer_province.service;


import com.codegym.customer_province.model.Customer;
import org.springframework.data.domain.Page;


import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer>{
    Page<Customer> findAllByProvince(String province, Pageable pageable);
}
