package com.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dto.FieldsProjectModel;
import com.domain.fieldsProject.FieldsProjectService;

@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("/fieldsProject")
public class FieldsProjectController {

    private FieldsProjectService fieldsProjectService;

    public FieldsProjectController(FieldsProjectService fieldsProjectService) {
        this.fieldsProjectService = fieldsProjectService;
    }

    @PostMapping
    public ResponseEntity<FieldsProjectModel> createFieldsProject(@RequestBody FieldsProjectModel fieldsProjectModel) {
        return ResponseEntity.ok( this.fieldsProjectService.createFieldsProject(fieldsProjectModel) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<FieldsProjectModel> updateFieldsProject(@PathVariable Long id, @RequestBody FieldsProjectModel fieldsProjectModel) {
        return ResponseEntity.ok( this.fieldsProjectService.updateFieldsProject(id, fieldsProjectModel) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FieldsProjectModel> getFieldsProjectById(@PathVariable Long id) {
        return ResponseEntity.ok( this.fieldsProjectService.getFieldsProjectById(id) );
    }

    @GetMapping
    public ResponseEntity<List<FieldsProjectModel>> getAllFieldsProject() {
        return ResponseEntity.ok( this.fieldsProjectService.getAllFieldsProject() );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFieldsProject(@PathVariable Long id) {
        fieldsProjectService.deleteFieldsProject(id);
        return ResponseEntity.noContent().build();
    }
}
