package com.SmartFlashCardSystem.SmartFlashCardSystems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlashcardResponse {
    private String question;
    private String answer;
    private String subject;
}

