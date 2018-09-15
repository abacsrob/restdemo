package com.example.restdemo.controller;

import com.example.restdemo.controller.exceptionhandler.CustomerNotFoundException;
import com.example.restdemo.entity.Customer;
import com.example.restdemo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.getById(id);
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        }
        throw new CustomerNotFoundException("Customer with id '" + String.valueOf(id) + "' was not found!", "/api/customers/" + id.toString());
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.saveOrUpdate(customer);
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.saveOrUpdate(customer);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.getById(id);
        if (customerOptional.isPresent()) {
            customerService.delete(id);
            return;
        }
        throw new CustomerNotFoundException("Customer with id '" + String.valueOf(id) + "' was not found while deleting!", "/api/customers/" + id.toString());
    }
}
