package com.example.reactivepostgresql.demo.repository;

import com.example.reactivepostgresql.demo.models.Customer;
import io.r2dbc.spi.Parameter;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
/**
 * autthor Tenzin Dawa
 */
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
}
