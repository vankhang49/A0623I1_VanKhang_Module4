package com.codegym.customer_management.service;

import com.codegym.customer_management.model.Customer;

public interface ICustomerService extends IGeneralService<Customer>{
    boolean insertWithStoredProcedure(Customer customer);
}
