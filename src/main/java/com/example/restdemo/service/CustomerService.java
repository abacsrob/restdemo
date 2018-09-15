package com.example.restdemo.service;

import com.example.restdemo.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public List<Customer> getAll();

    public Optional<Customer> getById(Long id);

    public Customer saveOrUpdate(Customer customer);

    public void delete(Long id);
}
