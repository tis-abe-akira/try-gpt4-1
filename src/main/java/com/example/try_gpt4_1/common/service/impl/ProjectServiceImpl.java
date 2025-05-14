package com.example.try_gpt4_1.common.service.impl;

import com.example.try_gpt4_1.common.dto.ProjectDto;
import com.example.try_gpt4_1.common.entity.Project;
import com.example.try_gpt4_1.common.repository.ProjectRepository;
import com.example.try_gpt4_1.common.service.ProjectService;
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
    public Project create(ProjectDto dto) {
        Project project = convertAndValidate(dto);
        projectRepository.insert(project);
        // useGeneratedKeysでproject.idに自動採番IDがセットされるギャル！
        return project;
    }

    @Override
    public void update(Long id, ProjectDto dto) {
        Project project = projectRepository.findById(id);
        if (project != null) {
            Project updated = convertAndValidate(dto);
            project.setCustomerId(updated.getCustomerId());
            project.setDepartmentName(updated.getDepartmentName());
            project.setManagerName(updated.getManagerName());
            project.setLeaderName(updated.getLeaderName());
            project.setRank(updated.getRank());
            project.setStartDate(updated.getStartDate());
            project.setEndDate(updated.getEndDate());
            project.setCategory(updated.getCategory());
            projectRepository.update(project);
        }
    }

    @Override
    public void delete(Long id) {
        projectRepository.delete(id);
    }

    private Project convertAndValidate(ProjectDto dto) {
        StringBuilder sb = new StringBuilder();
        boolean hasError = false;
        Project project = new Project();
        project.setId(dto.getId());
        project.setCustomerId(dto.getCustomerId());
        project.setDepartmentName(dto.getDepartmentName());
        project.setManagerName(dto.getManagerName());
        project.setLeaderName(dto.getLeaderName());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        // rank変換
        com.example.try_gpt4_1.common.dto.Rank rank = null;
        try {
            rank = com.example.try_gpt4_1.common.dto.Rank.valueOf(dto.getRank());
        } catch (Exception e) {
            sb.append("rankは[" + java.util.Arrays.toString(com.example.try_gpt4_1.common.dto.Rank.values())
                    + "]のいずれかを指定してね！（入力値: " + dto.getRank() + ")\n");
            hasError = true;
        }
        project.setRank(rank);
        // category変換
        com.example.try_gpt4_1.common.dto.Category category = null;
        try {
            category = com.example.try_gpt4_1.common.dto.Category.valueOf(dto.getCategory());
        } catch (Exception e) {
            sb.append("categoryは[" + java.util.Arrays.toString(com.example.try_gpt4_1.common.dto.Category.values())
                    + "]のいずれかを指定してね！（入力値: " + dto.getCategory() + ")\n");
            hasError = true;
        }
        project.setCategory(category);
        if (hasError) {
            throw new IllegalArgumentException(sb.toString().trim());
        }
        return project;
    }
}
