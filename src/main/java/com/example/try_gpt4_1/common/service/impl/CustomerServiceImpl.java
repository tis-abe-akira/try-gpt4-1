package com.example.try_gpt4_1.common.service.impl;

import com.example.try_gpt4_1.common.dto.CustomerDto;
import com.example.try_gpt4_1.common.entity.Customer;
import com.example.try_gpt4_1.common.repository.CustomerRepository;
import com.example.try_gpt4_1.common.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void create(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setContact(dto.getContact());
        customer.setIndustry(dto.getIndustry());
        customerRepository.insert(customer);
    }

    @Override
    public void update(Long id, CustomerDto dto) {
        Customer customer = customerRepository.findById(id);
        if (customer != null) {
            customer.setName(dto.getName());
            customer.setContact(dto.getContact());
            customer.setIndustry(dto.getIndustry());
            customerRepository.update(customer);
        }
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }
}
