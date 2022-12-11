package com.example.reactivepostgresql.demo.controller;

import com.example.reactivepostgresql.demo.models.Customer;
import com.example.reactivepostgresql.demo.repository.CustomerRepository;
import io.r2dbc.spi.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
/**
 * autthor Tenzin Dawa
 */ public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public Flux<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> getCustomerById(@PathVariable Integer id) {
        return customerRepository.findById(id);
    }

    @PostMapping
    public Mono<Customer> createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public Mono<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
        return customerRepository.findById(id).map(s -> {
            s.setName(customer.getName());
            s.setAge(customer.getAge());
            s.setAddress(customer.getAddress());
            return s;
        }).flatMap(s -> customerRepository.save(s));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCustomer(@PathVariable Integer id) {
        return customerRepository.deleteById(id);
    }
}
