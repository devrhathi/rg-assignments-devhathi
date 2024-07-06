package com.devhathi.batch_processing_demo.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;

import com.devhathi.batch_processing_demo.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(@NonNull Customer customer) throws Exception {
        if (customer.getCountry().equals("United States"))
            return customer;
        else
            return null;
    }

}
