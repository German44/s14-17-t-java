package com.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dto.feedbackModel;
import com.domain.feedback.feedbackService;

@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("/feedback")
public class feedbackController {

    private feedbackService feedbackService;

    public feedbackController(feedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<feedbackModel> createfeedback(@RequestBody feedbackModel feedbackModel) {
        return ResponseEntity.ok( this.feedbackService.createfeedback(feedbackModel) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<feedbackModel> updatefeedback(@PathVariable Long id, @RequestBody feedbackModel feedbackModel) {
        return ResponseEntity.ok( this.feedbackService.updatefeedback(id, feedbackModel) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<feedbackModel> getfeedbackById(@PathVariable Long id) {
        return ResponseEntity.ok( this.feedbackService.getfeedbackById(id) );
    }

    @GetMapping
    public ResponseEntity<List<feedbackModel>> getAllfeedback() {
        return ResponseEntity.ok( this.feedbackService.getAllfeedback() );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletefeedback(@PathVariable Long id) {
        feedbackService.deletefeedback(id);
        return ResponseEntity.noContent().build();
    }
}
