package com.example.try_gpt4_1.common.repository;

import com.example.try_gpt4_1.common.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(Long id);
    void insert(Customer customer);
    void update(Customer customer);
    void delete(Long id);
}
