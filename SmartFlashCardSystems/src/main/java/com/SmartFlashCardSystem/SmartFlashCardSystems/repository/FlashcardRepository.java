package com.SmartFlashCardSystem.SmartFlashCardSystems.repository;


import com.SmartFlashCardSystem.SmartFlashCardSystems.entity.FlashCard;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlashcardRepository extends JpaRepository<FlashCard, Long> {
    List<FlashCard> findByStudentId(String studentId);
}

