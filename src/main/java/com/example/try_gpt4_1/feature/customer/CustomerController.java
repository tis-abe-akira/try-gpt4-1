package com.example.try_gpt4_1.feature.customer;

import com.example.try_gpt4_1.common.dto.CustomerDto;
import com.example.try_gpt4_1.common.entity.Customer;
import com.example.try_gpt4_1.common.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Customer> create(@Validated @RequestBody CustomerDto dto) {
        Customer created = customerService.create(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Validated @RequestBody CustomerDto dto) {
        customerService.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
