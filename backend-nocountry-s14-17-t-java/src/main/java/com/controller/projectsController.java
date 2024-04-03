package com.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.domain.projects.ProjectsService;
import com.dto.ProjectsModel;

@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("/projects")
public class ProjectsController {

    private ProjectsService projectsService;

    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @PostMapping
    public ResponseEntity<ProjectsModel> createprojects(@RequestBody ProjectsModel projectsModel) {
        return ResponseEntity.ok( this.projectsService.createprojects(projectsModel) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectsModel> updateprojects(@PathVariable Long id, @RequestBody ProjectsModel projectsModel) {
        return ResponseEntity.ok( this.projectsService.updateprojects(id, projectsModel) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectsModel> getprojectsById(@PathVariable Long id) {
        return ResponseEntity.ok( this.projectsService.getprojectsById(id) );
    }

    @GetMapping
    public ResponseEntity<List<ProjectsModel>> getAllprojects() {
        return ResponseEntity.ok( this.projectsService.getAllprojects() );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteprojects(@PathVariable Long id) {
        projectsService.deleteprojects(id);
        return ResponseEntity.noContent().build();
    }
}
