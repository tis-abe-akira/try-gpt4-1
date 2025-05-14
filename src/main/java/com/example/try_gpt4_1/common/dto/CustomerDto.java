package com.example.try_gpt4_1.common.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class CustomerDto {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String contact;
    @NotBlank
    private String industry;
}
