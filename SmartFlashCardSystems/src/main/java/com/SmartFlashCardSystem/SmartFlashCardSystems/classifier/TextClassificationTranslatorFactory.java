package com.SmartFlashCardSystem.SmartFlashCardSystems.classifier;

import ai.djl.Model;
import ai.djl.translate.TranslateException;
import ai.djl.translate.Translator;
import ai.djl.util.Pair;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

public class TextClassificationTranslatorFactory implements ai.djl.translate.TranslatorFactory {
    @Override
    public Set<Pair<Type, Type>> getSupportedTypes() {
        return Set.of();
    }

    @Override
    public <I, O> Translator<I, O> newInstance(Class<I> aClass, Class<O> aClass1, Model model, Map<String, ?> map) throws TranslateException {
        return null;
    }
}
