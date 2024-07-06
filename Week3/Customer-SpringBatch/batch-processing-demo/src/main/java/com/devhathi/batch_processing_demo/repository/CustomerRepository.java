package com.devhathi.batch_processing_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devhathi.batch_processing_demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
