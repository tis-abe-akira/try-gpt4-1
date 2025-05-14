package com.example.try_gpt4_1.common.entity;

import lombok.Data;
import java.time.LocalDate;
import com.example.try_gpt4_1.common.dto.Rank;
import com.example.try_gpt4_1.common.dto.Category;

@Data
public class Project {
    private Long id;
    private Long customerId;
    private String departmentName;
    private String managerName;
    private String leaderName;
    private Rank rank; // S, A, B, C, D
    private LocalDate startDate;
    private LocalDate endDate;
    private Category category; // 新規開発・保守開発・パッケージ導入
}
