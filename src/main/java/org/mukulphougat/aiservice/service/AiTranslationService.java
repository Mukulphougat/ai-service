package org.mukulphougat.aiservice.service;

import lombok.extern.slf4j.Slf4j;
import org.mukulphougat.aiservice.entity.TranslationResponse;
import org.mukulphougat.aiservice.entity.TranslationResult;
import org.mukulphougat.aiservice.util.JsonExtractor;
import org.mukulphougat.aiservice.util.ResponseMapper;
import org.springframework.ai.mistralai.MistralAiChatModel;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AiTranslationService {
    private final MistralAiChatModel aiClient;
    public AiTranslationService(MistralAiChatModel aiClient) {
        this.aiClient = aiClient;
    }

    public TranslationResponse translateToHindi(String englishText) {
        String prompt =
                "Identify The Language Of The Give Text" +
                "Translate this sentence to Hindi" +
                        "Then Return It In A Json Object Not Return Additional Details Only Return A Json object with Keys givenText, language, translatedText:\n"+ englishText;
        String promptResponse = aiClient.call(prompt);
        TranslationResult finalResponse = JsonExtractor.extractTranslation(promptResponse);
        log.info(finalResponse.toString());
        return ResponseMapper.mapToTranslationResponse(finalResponse);
    }
}
