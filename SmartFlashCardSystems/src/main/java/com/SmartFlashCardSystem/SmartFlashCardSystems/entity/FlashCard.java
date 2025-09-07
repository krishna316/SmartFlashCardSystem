package com.SmartFlashCardSystem.SmartFlashCardSystems.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flashcards")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlashCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentId;
    private String question;
    private String answer;
    private String subject;
}

