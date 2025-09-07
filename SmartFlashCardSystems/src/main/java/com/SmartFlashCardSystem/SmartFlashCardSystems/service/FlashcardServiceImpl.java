package com.SmartFlashCardSystem.SmartFlashCardSystems.service;


import com.SmartFlashCardSystem.SmartFlashCardSystems.classifier.SubjectClassifier;
import com.SmartFlashCardSystem.SmartFlashCardSystems.dto.FlashcardRequest;
import com.SmartFlashCardSystem.SmartFlashCardSystems.dto.FlashcardResponse;
import com.SmartFlashCardSystem.SmartFlashCardSystems.entity.FlashCard;
import com.SmartFlashCardSystem.SmartFlashCardSystems.repository.FlashcardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlashcardServiceImpl implements FlashcardService {

    private final FlashcardRepository repository;
    private final SubjectClassifier classifier;

    @Override
    public FlashcardResponse addFlashcard(FlashcardRequest request) {
        String subject = classifier.detectSubject(request.getQuestion());
        FlashCard flashcard = FlashCard.builder()
                .studentId(request.getStudentId())
                .question(request.getQuestion())
                .answer(request.getAnswer())
                .subject(subject)
                .build();

        repository.save(flashcard);

        return FlashcardResponse.builder()
                .question(flashcard.getQuestion())
                .answer(flashcard.getAnswer())
                .subject(flashcard.getSubject())
                .build();
    }

    @Override
    public List<FlashcardResponse> getFlashcardsByStudent(String studentId, int limit) {
        List<FlashCard> flashcards = repository.findByStudentId(studentId);
        Collections.shuffle(flashcards); // randomize order
        return flashcards.stream()
                .limit(limit)
                .map(f -> new FlashcardResponse(f.getQuestion(), f.getAnswer(), f.getSubject()))
                .collect(Collectors.toList());
    }
}

