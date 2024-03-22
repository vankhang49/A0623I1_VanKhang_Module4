package com.codegym.customer_management.service;

import com.codegym.customer_management.model.Customer;

import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer>{
    Optional<Customer> findOne(Long id) throws Exception;
}
