package com.codegym.customer_management.repository;

import com.codegym.customer_management.model.Customer;

public interface ICustomerRepository extends IGeneralRepository<Customer> {
    boolean insertWithStoredProcedure(Customer customer);
}
