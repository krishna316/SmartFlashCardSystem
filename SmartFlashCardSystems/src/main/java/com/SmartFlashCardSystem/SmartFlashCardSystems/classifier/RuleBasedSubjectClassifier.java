package com.SmartFlashCardSystem.SmartFlashCardSystems.classifier;


import org.springframework.stereotype.Component;

@Component("ruleBasedClassifier")
public class RuleBasedSubjectClassifier implements SubjectClassifier {

    @Override
    public String detectSubject(String question) {
        String q = question.toLowerCase();
        if (q.contains("photosynthesis") || q.contains("cell") || q.contains("dna"))
            return "Biology";
        else if (q.contains("newton") || q.contains("force") || q.contains("velocity"))
            return "Physics";
        else if (q.contains("equation") || q.contains("algebra") || q.contains("theorem"))
            return "Mathematics";
        else if (q.contains("war") || q.contains("history") || q.contains("king"))
            return "History";
        else
            return "General";
    }
}

