package com.example.try_gpt4_1.common.entity;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Project {
    private Long id;
    private Long customerId;
    private String departmentName;
    private String managerName;
    private String leaderName;
    private String rank; // S, A, B, C, D
    private LocalDate startDate;
    private LocalDate endDate;
    private String category; // 新規開発・保守開発・パッケージ導入
}
