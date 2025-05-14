package com.example.try_gpt4_1.common.service;

import com.example.try_gpt4_1.common.dto.CustomerDto;
import com.example.try_gpt4_1.common.entity.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getAll();

    Customer getById(Long id);

    void create(CustomerDto dto);

    void update(Long id, CustomerDto dto);

    void delete(Long id);
}
