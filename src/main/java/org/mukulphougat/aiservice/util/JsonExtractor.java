package org.mukulphougat.aiservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mukulphougat.aiservice.entity.TranslationResult;

public class JsonExtractor {

    public static TranslationResult extractTranslation(String responseText) {
        try {
            // Find the JSON block (between ```json and ```)
            int start = responseText.indexOf("```json");
            int end = responseText.indexOf("```", start + 1);

            if (start == -1 || end == -1) {
                throw new IllegalArgumentException("JSON block not found in the response.");
            }

            String jsonBlock = responseText.substring(start + 7, end).trim(); // skip ```json

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonBlock, TranslationResult.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to extract or parse JSON", e);
        }
    }
}

