package com.example.try_gpt4_1.common.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ProjectDto {
    private Long id;
    @NotNull
    private Long customerId;
    @NotBlank
    private String departmentName;
    @NotBlank
    private String managerName;
    @NotBlank
    private String leaderName;
    @NotNull
    private Rank rank; // S, A, B, C, D
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @NotNull
    private Category category; // 新規開発・保守開発・パッケージ導入
}
