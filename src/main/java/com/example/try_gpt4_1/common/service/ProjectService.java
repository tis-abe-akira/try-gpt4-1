package com.example.try_gpt4_1.common.service;

import com.example.try_gpt4_1.common.dto.ProjectDto;
import com.example.try_gpt4_1.common.entity.Project;
import java.util.List;

public interface ProjectService {
    List<Project> getAll();

    Project getById(Long id);

    void create(ProjectDto dto);

    void update(Long id, ProjectDto dto);

    void delete(Long id);
}
