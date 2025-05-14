package com.example.try_gpt4_1.common.repository;

import com.example.try_gpt4_1.common.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ProjectRepository {
    List<Project> findAll();

    Project findById(Long id);

    void insert(Project project);

    void update(Project project);

    void delete(Long id);
}
