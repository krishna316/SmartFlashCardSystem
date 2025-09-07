package com.SmartFlashCardSystem.SmartFlashCardSystems.classifier;

import ai.djl.Application;
import ai.djl.inference.Predictor;
import ai.djl.modality.Classifications;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.translate.TranslateException;

public class MLBasedSubjectClassifier implements SubjectClassifier {

    private final ZooModel<String, Classifications> model;

    public MLBasedSubjectClassifier() throws Exception {
        // Load Hugging Face pretrained text classification model
        Criteria<String, Classifications> criteria = Criteria.builder()
                .optApplication(Application.NLP.TEXT_CLASSIFICATION)
                .setTypes(String.class, Classifications.class)
                .optModelUrls("https://huggingface.co/distilbert-base-uncased-finetuned-sst-2-english")
                .optTranslatorFactory(new TextClassificationTranslatorFactory()) // built-in translator
                .build();

        model = criteria.loadModel();
    }

    @Override
    public String detectSubject(String question) {
        try (Predictor<String, Classifications> predictor = model.newPredictor()) {
            Classifications result = predictor.predict(question);
            String label = result.best().getClassName(); // "POSITIVE" or "NEGATIVE"

            // Map Hugging Face labels -> Your subjects
            switch (label) {
                case "POSITIVE": return "Physics";
                case "NEGATIVE": return "Biology";
                default: return "General";
            }
        } catch (TranslateException e) {
            return "General";
        }
    }
}


