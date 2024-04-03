package com.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dto.fieldsModel;
import com.domain.fields.fieldsService;

@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("/fields")
public class fieldsController {

    private fieldsService fieldsService;

    public fieldsController(fieldsService fieldsService) {
        this.fieldsService = fieldsService;
    }

    @PostMapping
    public ResponseEntity<fieldsModel> createfields(@RequestBody fieldsModel fieldsModel) {
        return ResponseEntity.ok( this.fieldsService.createfields(fieldsModel) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<fieldsModel> updatefields(@PathVariable Long id, @RequestBody fieldsModel fieldsModel) {
        return ResponseEntity.ok( this.fieldsService.updatefields(id, fieldsModel) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<fieldsModel> getfieldsById(@PathVariable Long id) {
        return ResponseEntity.ok( this.fieldsService.getfieldsById(id) );
    }

    @GetMapping
    public ResponseEntity<List<fieldsModel>> getAllfields() {
        return ResponseEntity.ok( this.fieldsService.getAllfields() );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletefields(@PathVariable Long id) {
        fieldsService.deletefields(id);
        return ResponseEntity.noContent().build();
    }
}
