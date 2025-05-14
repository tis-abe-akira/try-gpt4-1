package com.example.try_gpt4_1.common.service.impl;

import com.example.try_gpt4_1.common.dto.ProjectDto;
import com.example.try_gpt4_1.common.entity.Project;
import com.example.try_gpt4_1.common.repository.ProjectRepository;
import com.example.try_gpt4_1.common.service.ProjectService;
import com.example.try_gpt4_1.common.dto.Rank;
import com.example.try_gpt4_1.common.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public void create(ProjectDto dto) {
        Project project = new Project();
        project.setCustomerId(dto.getCustomerId());
        project.setDepartmentName(dto.getDepartmentName());
        project.setManagerName(dto.getManagerName());
        project.setLeaderName(dto.getLeaderName());
        project.setRank(dto.getRank());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        project.setCategory(dto.getCategory());
        projectRepository.insert(project);
    }

    @Override
    public void update(Long id, ProjectDto dto) {
        Project project = projectRepository.findById(id);
        if (project != null) {
            project.setCustomerId(dto.getCustomerId());
            project.setDepartmentName(dto.getDepartmentName());
            project.setManagerName(dto.getManagerName());
            project.setLeaderName(dto.getLeaderName());
            project.setRank(dto.getRank());
            project.setStartDate(dto.getStartDate());
            project.setEndDate(dto.getEndDate());
            project.setCategory(dto.getCategory());
            projectRepository.update(project);
        }
    }

    @Override
    public void delete(Long id) {
        projectRepository.delete(id);
    }
}
