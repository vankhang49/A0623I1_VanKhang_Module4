package com.codegym.customer_province.service.Impl;
import com.codegym.customer_province.model.Customer;
import com.codegym.customer_province.repository.ICustomerRepository;
import com.codegym.customer_province.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAllByProvince(String province, Pageable pageable) {
        return customerRepository.searchByProvince("%" + province + "%", pageable);
    }
    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
