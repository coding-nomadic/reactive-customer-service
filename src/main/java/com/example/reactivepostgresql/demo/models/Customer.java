package com.example.reactivepostgresql.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
/**
 * autthor Tenzin Dawa
 */
public class Customer {
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer age;
    @Column
    private String address;

}
