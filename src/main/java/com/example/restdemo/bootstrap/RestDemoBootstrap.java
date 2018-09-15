package com.example.restdemo.bootstrap;

import com.example.restdemo.entity.Customer;
import com.example.restdemo.repository.CustomerRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class RestDemoBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CustomerRepository customerRepository;

    public RestDemoBootstrap(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        customerRepository.save(new Customer("New", "User", "newuser@email.com"));
        customerRepository.save(new Customer("John", "Doe", "johndoe@email.com"));
        customerRepository.save(new Customer("Jane", "'The Magnificent' Doe", "janedoe@email.com"));
    }

}
