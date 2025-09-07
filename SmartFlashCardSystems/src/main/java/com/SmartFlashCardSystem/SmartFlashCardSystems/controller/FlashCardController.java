package com.SmartFlashCardSystem.SmartFlashCardSystems.controller;

import com.SmartFlashCardSystem.SmartFlashCardSystems.dto.FlashcardRequest;
import com.SmartFlashCardSystem.SmartFlashCardSystems.dto.FlashcardResponse;
import com.SmartFlashCardSystem.SmartFlashCardSystems.service.FlashcardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FlashCardController {

    private final FlashcardService service;


    @PostMapping("/flashcard")
    public ResponseEntity<?> addFlashcard(@RequestBody FlashcardRequest request) {
        FlashcardResponse response = service.addFlashcard(request);
        return ResponseEntity.ok()
                .body(new Object() {
                    public final String message = "Flashcard added successfully";
                    public final String subject = response.getSubject();
                });
    }

    @GetMapping("/get-subject")
    public ResponseEntity<List<FlashcardResponse>> getFlashcardsBySubject(
            @RequestParam("student_id") String studentId,
            @RequestParam(defaultValue = "5") int limit
    ) {
        return ResponseEntity.ok(service.getFlashcardsByStudent(studentId, limit));
    }
}
