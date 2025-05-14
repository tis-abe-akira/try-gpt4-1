package com.example.try_gpt4_1.feature.project;

import com.example.try_gpt4_1.common.dto.ProjectDto;
import com.example.try_gpt4_1.common.entity.Project;
import com.example.try_gpt4_1.common.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable Long id) {
        return projectService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Project> create(@Validated @RequestBody ProjectDto dto) {
        Project created = projectService.create(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Validated @RequestBody ProjectDto dto) {
        projectService.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projectService.delete(id);
        return ResponseEntity.ok().build();
    }
}
