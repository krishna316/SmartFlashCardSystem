package com.SmartFlashCardSystem.SmartFlashCardSystems.service;


import com.SmartFlashCardSystem.SmartFlashCardSystems.dto.FlashcardRequest;
import com.SmartFlashCardSystem.SmartFlashCardSystems.dto.FlashcardResponse;

import java.util.List;

public interface FlashcardService {
    FlashcardResponse addFlashcard(FlashcardRequest request);
    List<FlashcardResponse> getFlashcardsByStudent(String studentId, int limit);
}

